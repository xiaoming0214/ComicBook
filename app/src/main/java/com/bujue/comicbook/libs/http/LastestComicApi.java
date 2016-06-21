package com.bujue.comicbook.libs.http;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * @author bujue
 * @description
 * @date 16/4/15
 */
public interface LastestComicApi {
    @GET("/ComicBooks/GetLastChapterForBookIds")
    Call<LastestComicMeta> search(
            @Query("idJson") String idJson
    );
}
