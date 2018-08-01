package com.example.abdulhakimbashir.zooapp

import android.content.Context
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.content.ContextCompat.startActivity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.BaseAdapter
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.animal_ticket.view.*

class MainActivity : AppCompatActivity() {
    var listOfAnimals = ArrayList<Animal>()
    var adapter:AnimalsAdapter?=null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        listOfAnimals.add(
                Animal("Baboon", "Baboon lives in a big place", R.drawable.baboon, false))
        listOfAnimals.add(
                Animal("Bulldog", "Bulldog lives in a big place", R.drawable.bulldog, false))
        listOfAnimals.add(
                Animal("Panda", "Panda lives in a big place", R.drawable.panda, true))
        listOfAnimals.add(
                Animal("Swallow", "Swallow lives in a big place", R.drawable.swallow_bird, false))
        listOfAnimals.add(
                Animal("Tiger", "Tiger lives in a big place", R.drawable.white_tiger, true))
        listOfAnimals.add(
                Animal("Zebra", "Zebra lives in a big place", R.drawable.zebra, false))

        adapter = AnimalsAdapter(this, listOfAnimals)
        tvListAnimal.adapter = adapter

//        tvListAnimal.setOnClickListener{
//
//            val me = Intent(this, AnimalInfo::class.java)
//            me.putExtra("name", animal.name!!)
//            me.putExtra("des", animal.des!!)
//            me.putExtra("image", animal.image!!)
//        }
        tvListAnimal.onItemClickListener = AdapterView.OnItemClickListener { parent, view, position, id ->
            // This is your listview's selected item
            val item = parent.getItemAtPosition(position) as Animal
            Toast.makeText(this, item.image.toString(), Toast.LENGTH_SHORT).show()
            val intent = Intent(this, AnimalInfo::class.java)
            intent.putExtra("name", item.name.toString())
            intent.putExtra("des", item.des.toString())
            intent.putExtra("image",  item.image)

            startActivity(intent)

        }
    }

    class AnimalsAdapter:BaseAdapter{
        var listOfAnimals = ArrayList<Animal>()
        var context:Context?=null
        constructor(context: Context, listOfAnimals: ArrayList<Animal>):super(){
            this.listOfAnimals = listOfAnimals
            this.context = context
        }

        override fun getView(p0: Int, p1: View?, p2: ViewGroup?): View {



           val animal = listOfAnimals[p0]
            if (animal.isKiller == true){
                var inflator = context!!.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
                var myView = inflator.inflate(R.layout.animal_killer_ticket, null)
                myView.tvName.text = animal.name!!
                myView.tvDes.text = animal.des!!
                myView.ivAnimalImage.setImageResource(animal.image!!)
                myView.ivAnimalImage.setOnClickListener{

                    val intent = Intent(context, AnimalInfo::class.java)
                    intent.putExtra("name", animal.name!!)
                    intent.putExtra("des", animal.des!!)
                    intent.putExtra("image", animal.image!!)
                    context!!.startActivity(intent)

                }
                return myView
            }else{
                var inflator = context!!.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
                var myView = inflator.inflate(R.layout.animal_ticket, null)
                myView.tvName.text = animal.name!!
                myView.tvDes.text = animal.des!!
                myView.ivAnimalImage.setImageResource(animal.image!!)
                myView.ivAnimalImage.setOnClickListener{
                    val intent = Intent(context, AnimalInfo::class.java)
                    intent.putExtra("name", animal.name!! )
                    intent.putExtra("des", animal.des!!)
                    intent.putExtra("image", animal.image!!)
                    context!!.startActivity(intent)
                }
                return myView
            }

        }

        override fun getItem(p0: Int): Any {
            return listOfAnimals[p0]
        }

        override fun getItemId(p0: Int): Long {
            return p0.toLong()
        }

        override fun getCount(): Int {
            return listOfAnimals.size
        }

    }
}

private fun Intent.putExtra(s: String) {}
