package com.example.proiectpiu_managementfinanciar.objective

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.proiectpiu_managementfinanciar.R
import com.example.proiectpiu_managementfinanciar.adapters.ObjectiveAdapter
import com.example.proiectpiu_managementfinanciar.util.ObjectiveManager

class ViewObjectivesActivity : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: ObjectiveAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.objective_view_all_activity)

        recyclerView = findViewById(R.id.objectivesRecyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)

        adapter = ObjectiveAdapter(ObjectiveManager.getObjectives())
        recyclerView.adapter = adapter
    }

    override fun onResume() {
        super.onResume()
        adapter.updateObjectives(ObjectiveManager.getObjectives())
        adapter.notifyDataSetChanged()
    }

}
