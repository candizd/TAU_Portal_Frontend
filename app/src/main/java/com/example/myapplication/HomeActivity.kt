package com.example.myapplication


import android.content.Intent
import android.os.Bundle
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import androidx.drawerlayout.widget.DrawerLayout
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.navigation.NavigationView


class HomeActivity : AppCompatActivity() {

    lateinit var toogle: ActionBarDrawerToggle
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        val recyclerView = findViewById<RecyclerView>(R.id.recyclerView3)
        recyclerView.layoutManager = GridLayoutManager(this, 2, GridLayoutManager.VERTICAL, false)
        val adapter = ItemListAdapter(MockList.getMockedItemList() as ArrayList<LessonModel>)
        recyclerView.adapter= adapter

        val recyclerView2 = findViewById<RecyclerView>(R.id.recyclerView4)
        recyclerView2.layoutManager = GridLayoutManager(this, 1, GridLayoutManager.VERTICAL, false)
        val adapter2 = AnnListAdapter(MockAnnList.getMockedItemList() as ArrayList<AnnModel>)
        recyclerView2.adapter= adapter2




        val drawerLayout : DrawerLayout = findViewById(R.id.drawerLayout)
        val navView : NavigationView = findViewById(R.id.nav_view)

        toogle = ActionBarDrawerToggle(this,drawerLayout,R.string.open,R.string.close)
        drawerLayout.addDrawerListener(toogle)
        toogle.syncState()

        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        navView.setNavigationItemSelectedListener {

            when(it.itemId) {

                R.id.nav_home -> Toast.makeText(applicationContext,"Clicked Home",Toast.LENGTH_SHORT).show()
                // R.id.nav_bus -> Toast.makeText(applicationContext,"Clicked Bus",Toast.LENGTH_SHORT).show()
                R.id.nav_bus -> startActivity(Intent(this, BusActivity::class.java))
                R.id.nav_food -> Toast.makeText(applicationContext,"Clicked Cafeteria",Toast.LENGTH_SHORT).show()

                R.id.nav_settings -> Toast.makeText(applicationContext,"Clicked Settings",Toast.LENGTH_SHORT).show()
                R.id.nav_logout -> Toast.makeText(applicationContext,"Clicked Logout",Toast.LENGTH_SHORT).show()
                R.id.nav_lesson -> Toast.makeText(applicationContext,"Clicked Course Schedule",Toast.LENGTH_SHORT).show()

                R.id.nav_map -> Toast.makeText(applicationContext,"Clicked Map",Toast.LENGTH_SHORT).show()
            }

            true
        }


    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if(toogle.onOptionsItemSelected(item)) {
            return true
        }
        return super.onOptionsItemSelected(item)
    }
}