package com.isilsubasi.myapplication


import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.isilsubasi.myapplication.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding:ActivityMainBinding
    private lateinit var avatarAdapter : AvatarAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initRecyclerView()



    }

    private fun initRecyclerView(){
        val avatarList=AvatarList.getAvatarList()

        binding.apply {
            avatarAdapter= AvatarAdapter(avatarList)
            rcyAvatar.adapter=avatarAdapter
            rcyAvatar.layoutManager= StaggeredGridLayoutManager(3, StaggeredGridLayoutManager.VERTICAL)
        }



    }

}