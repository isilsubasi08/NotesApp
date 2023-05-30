package com.isilsubasi.myapplication


import android.os.Bundle
import android.os.Handler
import android.view.MenuItem
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import androidx.recyclerview.widget.LinearLayoutManager

import com.isilsubasi.myapplication.databinding.ActivityNotesBinding


class NotesActivity : AppCompatActivity() {

    private lateinit var binding : ActivityNotesBinding
    private lateinit var appBarConfiguration:AppBarConfiguration
    private lateinit var mNavController:NavController
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityNotesBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setSupportActionBar(binding.appBarView.toolbar)//Belitilen toolbarı actionbar olarak ayarlar.
        setupNavDrawer()

    }
    /*
    NavigationDrawer'ı ayarlamak, fragment'lar arasında gezinmeyi yönetmek
    ve ActionBar ile uyumlu hale getirmek için gereken yapılandırmaları yapar.
     */
    private fun setupNavDrawer(){
        val navDrawer=binding.navView
        val drawerLayout=binding.drawerLayout
        //Uygulama içinde fragment'ları barındıran bir konteyner görevi görür.
        val navHostFragment=supportFragmentManager.findFragmentById(R.id.fragmentHost) as NavHostFragment
        //NavController, fragment'ların arasında gezinmeyi yöneten bir kontrolcüdür.
        mNavController=navHostFragment.navController
        appBarConfiguration= AppBarConfiguration(
            setOf(
                R.id.listFragment,R.id.notesFragment,R.id.settingsFragment
            ),drawerLayout
        )// Bu yapı, NavigationDrawer'ın hangi fragment'lara sahip olduğunu ve hangi DrawerLayout ile ilişkili olduğunu belirtir.
        setupActionBarWithNavController(mNavController,appBarConfiguration)//Bu, ActionBar'ın geri düğmesini ve NavigationDrawer'ı etkinleştirir.
        navDrawer.setupWithNavController(mNavController)// Bu, NavigationDrawer'ın menü öğeleri ve gezinme işlemleri ile NavController'a bağlanmasını sağlar.
    }

    /*
    onSupportNavigateUp() fonksiyonu, geri düğmesine veya NavigationDrawer'daki gezinme düğmesine basıldığında fragment'lar arasında geriye doğru geçiş yapmayı dener
     ve bu geçiş başarılı ise true döndürür. Başarılı geçiş yapılamazsa, varsayılan geri dönüş işlemi gerçekleştirilir.
     */
    override fun onSupportNavigateUp(): Boolean {
        return mNavController.navigateUp(appBarConfiguration)||super.onSupportNavigateUp()
    }
}