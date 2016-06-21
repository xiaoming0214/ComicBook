package com.bujue.comicbook.libs.http;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * @author bujue
 * @date 16/4/18
 */
public interface SearchComicApi {
    @GET("/ComicBooks/GetAllBook")
    Call<SearchComicMeta> search(
            @Query("Title") String title
    );
}
