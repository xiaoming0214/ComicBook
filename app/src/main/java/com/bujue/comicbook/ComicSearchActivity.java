package com.bujue.comicbook;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.Toolbar;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.bujue.comicbook.constant.URLConstant;
import com.bujue.comicbook.libs.http.SearchComicApi;
import com.bujue.comicbook.libs.http.SearchComicMeta;
import com.bujue.comicbook.view.SearchEditText;
import com.bumptech.glide.Glide;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * @author bujue
 * @date 16/4/18
 */
public class ComicSearchActivity extends BaseActivity{

    SearchEditText mSearchEditText;
    ListView mListView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.comic_search_layout);

        Toolbar toolBar = (Toolbar) this.findViewById(R.id.toolbar);
        setSupportActionBar(toolBar);

        mSearchEditText = (SearchEditText) this.findViewById(R.id.comic_search_edt);
        mListView = (ListView) this.findViewById(R.id.comic_search_list_view);

        mSearchEditText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                doSearch(editable.toString());
            }
        });
    }

    /**
     * 搜索XX
     * @param searchValue
     */
    private void doSearch(String searchValue){
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(URLConstant.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        SearchComicApi searchComic = retrofit.create(SearchComicApi.class);

        Call<SearchComicMeta> call = searchComic.search(searchValue);

        call.enqueue(new Callback<SearchComicMeta>() {
            @Override
            public void onResponse(Call<SearchComicMeta> call, Response<SearchComicMeta> response) {
                final SearchComicMeta meta = response.body();
                System.out.println("meta = " + meta.toString());

                SearchAdapter adapter = new SearchAdapter(meta.getReturn().getList());
                mListView.setAdapter(adapter);
                mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                        SearchComicMeta.ReturnEntity.ListEntity entity =
                                (SearchComicMeta.ReturnEntity.ListEntity)adapterView.getAdapter().getItem(i);
                        Intent intent = new Intent(ComicSearchActivity.this,ComicChapterActivity.class);
                        intent.putExtra("COMIC_ID",entity.getId());
                        startActivity(intent);

                    }
                });
            }

            @Override
            public void onFailure(Call<SearchComicMeta> call, Throwable t) {

            }
        });
    }

    class SearchAdapter extends BaseAdapter{

        private List<SearchComicMeta.ReturnEntity.ListEntity> mList;

        public SearchAdapter(List<SearchComicMeta.ReturnEntity.ListEntity> list){
            this.mList = list;
        }

        public void setData(List<SearchComicMeta.ReturnEntity.ListEntity> list){
            this.mList = list;
        }

        @Override
        public int getCount() {
            return mList == null ? 0 : mList.size();
        }

        @Override
        public SearchComicMeta.ReturnEntity.ListEntity getItem(int i) {
            return mList == null ? null : mList.get(i);
        }

        @Override
        public long getItemId(int i) {
            return i;
        }

        @Override
        public View getView(int i, View view, ViewGroup viewGroup) {
            ViewHolder viewHolder = null;
            if(viewHolder == null){
                viewHolder = new ViewHolder();
                view = LayoutInflater.from(ComicSearchActivity.this).inflate(R.layout.comic_search_list_item,viewGroup,false);
                viewHolder.itemImage = (ImageView) view.findViewById(R.id.search_item_image);
                viewHolder.itemText = (TextView) view.findViewById(R.id.search_item_text);
                view.setTag(viewHolder);
            }else{
                viewHolder = (ViewHolder) view.getTag();
            }

            SearchComicMeta.ReturnEntity.ListEntity entity = mList.get(i);
            Glide.with(ComicSearchActivity.this).load(entity.getFrontCover()).into(viewHolder.itemImage);
            viewHolder.itemText.setText(entity.getTitle());
            return view;
        }

        class ViewHolder{
            ImageView itemImage;
            TextView itemText;
        }
    }
}
