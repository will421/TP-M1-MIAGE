package fr.will421.tp4_correction;

import retrofit2.Call;
import retrofit2.http.GET;

public interface YesNoService {
    @GET("api")
    Call<YesNoAnswer> getAnswer();
}
