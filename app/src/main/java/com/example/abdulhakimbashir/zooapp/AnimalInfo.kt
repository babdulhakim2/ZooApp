package com.example.abdulhakimbashir.zooapp

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.animal_ticket.*

class AnimalInfo : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_animal_info)

//        val bundle:Bundle = intent.extras
//        val name = bundle.getString("name")
//        val des = bundle.getString("des")
//        val image = bundle.getInt("image")
//
//        ivAnimalImage.setImageResource(image)
//        tvName.text = name
//        tvDes.text = des
        var setName: String = intent.getStringExtra("name")
        var setDesc: String = intent.getStringExtra("des")
//        var setImage: String = intent.getStringExtra("image")
        var setImage = intent.getIntExtra("image", 2)

        ivAnimalImage.setImageResource(setImage)
        tvName.text = setName
        tvDes.text = setDesc
    }
}
