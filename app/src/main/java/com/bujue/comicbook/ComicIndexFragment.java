package com.bujue.comicbook;

import android.content.Intent;
import android.graphics.Rect;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bujue.comicbook.constant.URLConstant;
import com.bujue.comicbook.libs.http.LastestComicApi;
import com.bujue.comicbook.libs.http.LastestComicMeta;
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
public class ComicIndexFragment extends BaseFragment {

    RecyclerView mRecyclerView = null;
    IndexAdapter mRecycleAdapter = null;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.comic_index,container,false);
        Toolbar toolBar = (Toolbar) rootView.findViewById(R.id.toolbar);
        mRecyclerView = (RecyclerView) rootView.findViewById(R.id.comic_index_listview);

        initData();
        return rootView;
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        inflater.inflate(R.menu.menu_comic_index, menu);
        super.onCreateOptionsMenu(menu, inflater);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.comic_search) {
            Intent intent = new Intent(getActivity(), ComicSearchActivity.class);
            startActivity(intent);
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    private String initIdJson(){
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("[");
        for(int i = 0; i < 100 ; i++){
            stringBuilder.append(i);
            stringBuilder.append(",");
        }
        stringBuilder.append("]");
        return stringBuilder.toString();
    }

    private void initData() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(URLConstant.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        LastestComicApi searchComic = retrofit.create(LastestComicApi.class);

        Call<LastestComicMeta> call = searchComic.search(initIdJson());

        call.enqueue(new Callback<LastestComicMeta>() {
            @Override
            public void onResponse(Call<LastestComicMeta> call, Response<LastestComicMeta> response) {
                final LastestComicMeta meta = response.body();
                System.out.println("meta = " + meta.toString());
                //设置layoutManager
                mRecyclerView.setLayoutManager(new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL));
                //设置adapter
                mRecycleAdapter = new IndexAdapter(meta.getReturn().getList());
                mRecyclerView.setAdapter(mRecycleAdapter);
                //设置item之间的间隔
                SpacesItemDecoration decoration = new SpacesItemDecoration(50);
                mRecyclerView.addItemDecoration(decoration);

            }

            @Override
            public void onFailure(Call<LastestComicMeta> call, Throwable t) {

            }
        });
    }

    public class SpacesItemDecoration extends RecyclerView.ItemDecoration {

        private int space;

        public SpacesItemDecoration(int space) {
            this.space = space;
        }

        @Override
        public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
            outRect.left = space;
            outRect.right = space;
            outRect.bottom = space;
            if (parent.getChildAdapterPosition(view) == 0) {
                outRect.top = space;
            }
        }
    }


    public class IndexAdapter extends RecyclerView.Adapter<IndexAdapter.MyHolder> {
        private List<LastestComicMeta.ReturnEntity.ListEntity> mList;

        public IndexAdapter(List<LastestComicMeta.ReturnEntity.ListEntity> list) {
            this.mList = list;
        }

        public void setData(List<LastestComicMeta.ReturnEntity.ListEntity> list) {
            this.mList = list;
        }

        @Override
        public MyHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
            View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.comic_index_list_item, viewGroup, false);
            return new MyHolder(view);
        }

        @Override
        public void onBindViewHolder(MyHolder holder, int position) {
            LastestComicMeta.ReturnEntity.ListEntity entity = mList.get(position);
            String imageUrl = entity.getFrontCover();
            String bookTitle = entity.getBook().getTitle();
            String title = entity.getTitle();

            Glide.with(getActivity()).load(imageUrl).into(holder.imageView);
            holder.textView.setText(bookTitle + "_" + title);

            final int comicId = entity.getId();
            holder.imageView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    String comicUrl = String.format(URLConstant.COMIC_URL, comicId);
                    Intent intent = new Intent(getActivity(), ComicPreviewActivity.class);
                    intent.putExtra("COMIC_URL", comicUrl);
                    startActivity(intent);
                }
            });

        }

        @Override
        public int getItemCount() {
            return mList == null ? 0 : mList.size();
        }


        class MyHolder extends RecyclerView.ViewHolder {

            ImageView imageView;
            TextView textView;

            public MyHolder(View itemView) {
                super(itemView);
                imageView = (ImageView) itemView.findViewById(R.id.item_image);
                textView = (TextView) itemView.findViewById(R.id.item_text);
            }

        }

    }
}
