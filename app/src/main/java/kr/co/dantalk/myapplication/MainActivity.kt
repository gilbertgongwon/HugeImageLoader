package kr.co.dantalk.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import kr.co.dantalk.myapplication.databinding.ActivityMainBinding
import java.util.*
import kotlin.collections.ArrayList

class MainActivity : AppCompatActivity() {

    val imageList:ArrayList<String> = ArrayList()
    val binding: ActivityMainBinding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        setData()
        setRv()
    }

    private fun setRv() {
        binding.imageRV.apply {
            layoutManager = GridLayoutManager(this@MainActivity, 3)
            adapter = ImageAdapter().apply {
                setData(imageList)
            }
        }
    }

    private fun setData() {
        for(i in 1..100000) {
            imageList.add("https://picsum.photos/id/${Random().nextInt(800)+100}/300/300")
        }
    }
}