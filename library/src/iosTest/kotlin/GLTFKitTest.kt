import gltfkit.GLTFAsset
import kotlinx.cinterop.ExperimentalForeignApi
import kotlin.test.Test

@OptIn(ExperimentalForeignApi::class)
class GLTFKitTest {

    @Test
    fun `test GLTFAsset creation`() {
        val asset = GLTFAsset.new()
        println(asset)
    }
}
