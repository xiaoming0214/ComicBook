package com.bujue.comicbook;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;

import com.bujue.comicbook.constant.URLConstant;
import com.bujue.comicbook.libs.http.ChapterComicApi;
import com.bujue.comicbook.libs.http.ChapterComicMeta;
import com.bumptech.glide.Glide;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * 漫画章节
 * @author bujue
 * @date 16/4/18
 */
public class ComicChapterActivity extends BaseActivity {

    int comicId;

    @Bind(R.id.comic_chapter_image)
    ImageView mComicImage;
    @Bind(R.id.comic_chapter_name)
    TextView mNameText;
    @Bind(R.id.comic_chapter_author)
    TextView mAuthorText;
    @Bind(R.id.comic_chapter_tag)
    TextView mTagText;
    @Bind(R.id.comic_chapter_state)
    TextView mStateText;
    @Bind(R.id.comic_chapter_grid)
    GridView mChapterGrid;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.comic_chapter);

        Toolbar toolBar = (Toolbar) this.findViewById(R.id.toolbar);
        setSupportActionBar(toolBar);

        ButterKnife.bind(this);
        // 初始化Intent
        initIntent();
        // 初始化Data
        initData();
    }

    private void initIntent(){
        Intent intent = getIntent();
        if(intent == null){
            return;
        }
        comicId = intent.getIntExtra("COMIC_ID",0);
    }

    private void initData(){
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(URLConstant.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        ChapterComicApi chapterComicApi = retrofit.create(ChapterComicApi.class);

        Call<ChapterComicMeta> call = chapterComicApi.chapter(comicId,0);

        call.enqueue(new Callback<ChapterComicMeta>() {
            @Override
            public void onResponse(Call<ChapterComicMeta> call, Response<ChapterComicMeta> response) {
                final ChapterComicMeta meta = response.body();
                System.out.println("meta = "+meta.toString());
                String imageUrl = meta.getReturn().getParentItem().getFrontCover();
                String name = meta.getReturn().getParentItem().getTitle();
                String author = meta.getReturn().getParentItem().getAuthor();

                Glide.with(ComicChapterActivity.this).load(imageUrl).into(mComicImage);
                mNameText.setText(name);
                mAuthorText.setText(author);

                ChapterGridAdapter adapter = new ChapterGridAdapter(meta.getReturn().getList());
                mChapterGrid.setAdapter(adapter);
                mChapterGrid.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                        ChapterComicMeta.ReturnEntity.ListEntity entity =
                                (ChapterComicMeta.ReturnEntity.ListEntity)adapterView.getAdapter().getItem(i);

                        String comicUrl = String.format(URLConstant.COMIC_URL, entity.getId());
                        Intent intent = new Intent(ComicChapterActivity.this, ComicPreviewActivity.class);
                        intent.putExtra("COMIC_URL", comicUrl);
                        startActivity(intent);
                    }
                });
            }

            @Override
            public void onFailure(Call<ChapterComicMeta> call, Throwable t) {

            }
        });
    }

    class ChapterGridAdapter extends BaseAdapter{

        List<ChapterComicMeta.ReturnEntity.ListEntity> mList;

        public ChapterGridAdapter(List<ChapterComicMeta.ReturnEntity.ListEntity> list){
            this.mList = list;
        }

        public void setData(List<ChapterComicMeta.ReturnEntity.ListEntity> list){
            this.mList = list;
        }

        @Override
        public int getCount() {
            return mList == null ? 0 : mList.size();
        }

        @Override
        public ChapterComicMeta.ReturnEntity.ListEntity getItem(int i) {
            return mList.get(i);
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
                view = LayoutInflater.from(ComicChapterActivity.this).inflate(R.layout.comic_chapter_grid_item,viewGroup,false);
                viewHolder.itemText = (TextView) view.findViewById(R.id.chapter_item_text);
                view.setTag(viewHolder);
            }else{
                viewHolder = (ViewHolder) view.getTag();
            }

            ChapterComicMeta.ReturnEntity.ListEntity entity = mList.get(i);
            viewHolder.itemText.setText(entity.getChapterNo() + "");
            return view;
        }

        class ViewHolder{
            TextView itemText;
        }

    }

}
