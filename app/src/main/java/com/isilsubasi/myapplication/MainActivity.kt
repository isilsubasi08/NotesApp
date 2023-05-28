package com.isilsubasi.myapplication


import android.app.Dialog
import android.content.Intent
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.isilsubasi.myapplication.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding:ActivityMainBinding
    private lateinit var avatarAdapter : AvatarAdapter
    private lateinit var mDialog : Dialog
    private lateinit var avatarList :List<AvatarModel>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initRecyclerView()



    }

    private fun initRecyclerView(){
        avatarList=AvatarList.getAvatarList()
        binding.apply {
            avatarAdapter= AvatarAdapter(avatarList,object : ItemClickListener{
                override fun onItemClick(position: Int) {
                    initDialog()
                    startTimer(avatarList[position].imageSrc)
                }
            })
            rcyAvatar.adapter=avatarAdapter
            rcyAvatar.layoutManager= StaggeredGridLayoutManager(3, StaggeredGridLayoutManager.VERTICAL)
        }
    }

    private fun initDialog(){
        mDialog=Dialog(this@MainActivity)
        mDialog.setContentView(R.layout.custom_popup)
        val dialogImageView = mDialog.findViewById<ImageView>(R.id.dialog_imageView)
        val dialogTextView=mDialog.findViewById<TextView>(R.id.dialog_txt)
        dialogImageView.setImageResource(R.drawable.main_image)
        dialogTextView.text="Hadi Başlayalım :)"
        mDialog.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        mDialog.show()
    }

    private fun startTimer(imageSrc : Int){
        val countDownTimer = object : CountDownTimer(1000, 1000) {
            override fun onTick(millisUntilFinished: Long) {
            }
            override fun onFinish() {
               nextActivity(imageSrc)
            }
        }

        countDownTimer.start()
    }

    private fun nextActivity(imageSrc : Int){
        val intent=Intent(this,NotesActivity::class.java)
        intent.putExtra("imageSrc",imageSrc)
        startActivity(intent)
    }

}