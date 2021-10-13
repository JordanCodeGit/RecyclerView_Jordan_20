package com.example.recyclerview_jordan_20

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    companion object {
        val INTENT_PARCELABLE = "OBJECT_INTENT"
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val superheroList = listOf<Superhero>(
            Superhero(
                R.drawable.venti,
                "Venti",
                "Barbatos, also known as the Anemo Archon, Lord Barbatos, the God of Freedom, and currently as Venti.\n"+
                        "Originally a minor elemental spirit, Barbatos rose to divinity after the defeat of the tyrannical Anemo Archon Decarabian. \n" +
                        "Barbatos, as the God of Freedom and the new Anemo Archon, moulded the land of Mondstadt into a nation ran by its people rather than its Archon."
            ),
            Superhero(
                R.drawable.zhongli,
                "Zhongli",
                "Morax, also known as the God of Contracts and Rex Lapis (Chinese: 岩王帝君 Yánwáng Dìjūn), was the previous Geo Archon and one of The Seven who presided over Liyue. He is also one of The Seven's two original members who are still alive at the start of the game.\n" +
                        "He currently wanders the world as Zhongli, a consultant for the Wangsheng Funeral Parlor."
            ),
            Superhero(
                R.drawable.baal,
                "Raiden Shogun",
                "Beelzebul, real name Raiden Ei (Japanese: 雷電影 Raiden Ei, \"Shadow of Thunder\"), also known as the God of Eternity and the current Raiden Shogun (Japanese: 雷電将軍 Raiden Shougun), is the current Electro Archon and member of The Seven who presides over Inazuma. She is the Almighty Shogun of the Inazuma Shogunate which rules over the country."
            ),
            Superhero(
                R.drawable.ganyu,
                "Ganyu",
                "The secretary to the Liyue Qixing. The blood of both human and illuminated beast flows within her veins.\n" +
                        "Graceful and quiet by nature, yet the gentle disposition of qilin sees not even the slightest conflict with even the most arduous of workloads.\n" +
                        "After all, Ganyu firmly believes that all the work she does is in honor of her contract with Rex Lapis, seeking the well-being of all living things within Liyue."
            ),
            Superhero(
                R.drawable.childe,
                "Childe",
                "Meet Tartaglia — the cunning Snezhnayan whose unpredictable personality keeps people guessing his every move.\n" +
                        "Don't be under any illusion as to what he might be thinking or what his intentions are. Just remember this: Behind that innocent, childlike exterior lies a finely honed instrument of war."
            )
        )

        val recyclerView = findViewById<RecyclerView>(R.id.rv_hero)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.setHasFixedSize(true)
        recyclerView.adapter = SuperheroAdapter(this, superheroList) {
            val intent = Intent (this, DetailSuperheroActivity::class.java)
            intent.putExtra(INTENT_PARCELABLE, it)
            startActivity(intent)
        }
    }
}