package com.crafter.remindme

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.navigation.NavType
import androidx.navigation.createGraph
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.fragment.fragment
import com.crafter.remindme.databinding.ActivityMainBinding
import com.crafter.remindme.navigation.nav_arguments
import com.crafter.remindme.navigation.nav_routes
import com.crafter.remindme.ui.component.addReminder.AddReminderFragment
import com.crafter.remindme.ui.component.reminderList.ReminderListFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private lateinit var binding:ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.nav_host_fragment)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        // View binding
        binding = ActivityMainBinding.inflate(layoutInflater)

        // attaching navController with nav host
        val navHostFragment =supportFragmentManager.findFragmentById(R.id.nav_host_fragment) as NavHostFragment
        val navController = navHostFragment.navController

        // Created a nav graph
        navController.graph = navController.createGraph(startDestination = nav_routes.reminder_list){

            fragment<ReminderListFragment>(nav_routes.reminder_list){
                label = resources.getString(R.string.reminder_list_title)
            }
            fragment<AddReminderFragment>("${nav_routes.add_reminder}/{${nav_arguments.reminder_id}}"){
                label= resources.getString(R.string.add_reminder_title)
                argument(nav_arguments.reminder_id){
                    type= NavType.StringType
                }
            }

        }
    }
}