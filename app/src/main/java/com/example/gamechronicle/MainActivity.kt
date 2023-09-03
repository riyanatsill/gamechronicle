package com.example.gamechronicle
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    private lateinit var gameRV: RecyclerView
    private val list = ArrayList<Games>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        gameRV = findViewById(R.id.rv_game)
        gameRV.setHasFixedSize(true)

        list.addAll(getGameList())

        gameRV.layoutManager = LinearLayoutManager(this)

        val gamelist = GameAdapter(list, this)
        gameRV.adapter = gamelist
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.about_page -> {
                val moveIntent = Intent(this@MainActivity, AboutActivity::class.java)
                startActivity(moveIntent)
            }
        }
        return super.onOptionsItemSelected(item)
    }

    private fun getGameList(): ArrayList<Games> {
        val dataGame = resources.getStringArray(R.array.game_data)
        val dataDetail = resources.getStringArray(R.array.details_data)
        val dataOverview = resources.getStringArray(R.array.overview_data)
        val dataPhoto = resources.obtainTypedArray(R.array.photo_data)
        val gamelist = ArrayList<Games>()
        for (i in dataGame.indices) {
            val game = Games(dataGame[i], dataOverview[i], dataPhoto.getResourceId(i, -1), dataDetail[i],)
            gamelist.add(game)
        }
        dataPhoto.recycle()
        return gamelist
    }
}
