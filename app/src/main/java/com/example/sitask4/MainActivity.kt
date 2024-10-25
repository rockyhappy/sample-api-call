package com.example.sitask4

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.navigation.NavController
import androidx.navigation.Navigation
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {

    private lateinit var navController: NavController
    private lateinit var bottomNavigationView: BottomNavigationView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        navController = Navigation.findNavController(this, R.id.nav_host_fragment)

        bottomNavigationView = findViewById(R.id.bottom_navigation)

        val userName = bottomNavigationView.menu.findItem(R.id.username)
        userName.setOnMenuItemClickListener {
            navController.navigate(R.id.userFragment2)
            bottomNavigationView.menu.findItem(R.id.username).isChecked = true
            true
        }

        val home = bottomNavigationView.menu.findItem(R.id.home)
        home.setOnMenuItemClickListener {
            navController.navigate(R.id.homeFragment2)
            bottomNavigationView.menu.findItem(R.id.home).isChecked = true
            true
        }

        val badges = bottomNavigationView.menu.findItem(R.id.badges)
        badges.setOnMenuItemClickListener {
            navController.navigate(R.id.badgeFragment2)
            bottomNavigationView.menu.findItem(R.id.badges).isChecked = true
            true
        }

        val solved = bottomNavigationView.menu.findItem(R.id.solved)
        solved.setOnMenuItemClickListener {
            navController.navigate(R.id.solvedFragment2)
            bottomNavigationView.menu.findItem(R.id.solved).isChecked = true
            true
        }

        val submissions = bottomNavigationView.menu.findItem(R.id.submission)
        submissions.setOnMenuItemClickListener {
            navController.navigate(R.id.submissionFragment2)
            bottomNavigationView.menu.findItem(R.id.submission).isChecked = true
            true
        }

    }
    override fun onBackPressed() {
        if (navController.currentDestination?.id != R.id.homeFragment2) {
            navController.popBackStack(R.id.homeFragment2, false)
            bottomNavigationView.menu.findItem(R.id.home).isChecked = true
        } else {
            super.onBackPressed()
        }
    }
}