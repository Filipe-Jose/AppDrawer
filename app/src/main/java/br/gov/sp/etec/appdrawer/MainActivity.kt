package br.gov.sp.etec.appdrawer

import android.os.Bundle
import android.view.Gravity
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.core.view.GravityCompat
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.drawerlayout.widget.DrawerLayout
import com.google.android.material.navigation.NavigationView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.drawer_layout)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val toolbar = findViewById<Toolbar>(R.id.toolbar)
        val drawer = findViewById<DrawerLayout>(R.id.drawer_layout)
        val menu = findViewById<NavigationView>(R.id.navigationView)
        val texto = findViewById<TextView>(R.id.txtConteudo)

        toolbar.setNavigationOnClickListener {
            drawer.openDrawer(GravityCompat.START)
        }

        menu.setNavigationItemSelectedListener {
            item ->
            when(item.itemId) {
                R.id.menuInicio -> {texto.text = "Tela Inicial"}
                R.id.menuPerfil -> {texto.text = "Perfil"}
                R.id.menuConfiguracao -> {texto.text = "Configurações"}
            }
            drawer.closeDrawer(GravityCompat.START)
            true
        }
    }
}