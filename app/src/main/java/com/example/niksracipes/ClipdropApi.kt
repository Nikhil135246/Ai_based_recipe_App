import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.Headers
import retrofit2.http.POST

data class TextToImageRequest(
    val prompt: String
)

data class TextToImageResponse(
    val url: String // URL to the generated image
)

interface ClipdropApi {
    @Headers("Authorization: Bearer 891326d10d88fc4f768736c34313bb83b2020b2534594c4d0b778c23e798a0c9383e8bf48103f931f773b8e9fc9a8a92", "Content-Type: application/json")
    @POST("v1/generate-image")
    fun generateImage(@Body request: TextToImageRequest): Call<TextToImageResponse>
}
