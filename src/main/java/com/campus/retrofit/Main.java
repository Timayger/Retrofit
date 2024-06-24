package com.campus.retrofit;

import retrofit2.Response;
import com.campus.retrofit.response.PostResponse;
import com.campus.retrofit.request.PostCreateRequest;
import com.campus.retrofit.request.PostUpdateRequest;
import java.io.IOException;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        System.out.println("Hello World!");

        JsonPlaceholderApi api = JsonPlaceholderService.getInstance().api();

        System.out.println("GET ---------");
        Response<List<PostResponse>> postsResponse = api.posts(null).execute();
        System.out.println(postsResponse.isSuccessful());
        System.out.println(postsResponse.headers());
        System.out.println(postsResponse.code());
        System.out.println(postsResponse.headers());
        System.out.println(postsResponse.body());

        System.out.println("POST: -----------------");
        PostCreateRequest createRequest = new PostCreateRequest();
        createRequest.setBody("Body");
        createRequest.setTitle("title");
        createRequest.setUserId(1);
        Response<PostResponse> createResponse = api.create(createRequest).execute();
        System.out.println(createResponse.body());

        System.out.println("PUT: ------------------ ");
        PostUpdateRequest updateRequest = new PostUpdateRequest();
        updateRequest.setBody("Body"); updateRequest.setTitle("title");
        updateRequest.setUserId(1);
        updateRequest.setId(1);
        Response<PostResponse> updateResponse = api.update(1, updateRequest).execute();
        System.out.println(updateResponse.body());

        System.out.println("DELETE: ---------------");
        Integer statusCode = api.delete(1).execute().code();
        System.out.println(statusCode);

    }
}
