package com.example.samplegetretrofitwithmvvm

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import android.widget.ViewSwitcher
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.samplegetretrofitwithmvvm.adapter.AdapterRetro
import com.example.samplegetretrofitwithmvvm.databinding.ActivityMainBinding
import com.example.samplegetretrofitwithmvvm.module.ModuleRetro
import com.example.samplegetretrofitwithmvvm.repository.RepositoryData
import com.example.samplegetretrofitwithmvvm.viewModel.MainView
import com.example.samplegetretrofitwithmvvm.viewModel.MainViewFactory
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.item_list.*
import retrofit2.Response

class MainActivity : AppCompatActivity()
{
    // Binding
    private lateinit var binding: ActivityMainBinding

    // View Model
    private lateinit var viewModel: MainView

    // Adapter
    private val listSheets: ArrayList<ModuleRetro> = arrayListOf()
    private val myAdapter by lazy { AdapterRetro() }

    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        // Implement Binding
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // RecyclerView
        showRecyclerView()

        // Initialize view Model
        val viewFactory = MainViewFactory(RepositoryData())

        // Implement View Model and View Model Factory
        viewModel = ViewModelProvider(this, viewFactory).get(MainView::class.java)

        // =================================================
        //                  Get Multi Data
        // =================================================
        val options: HashMap<String, String> = HashMap()
        options["_sort"] = "id"
        options["_order"] = "desc"

        viewModel.multiData("Sample Authentication", "Sample Token", 6, options)

        viewModel.multiJSON.observe(this, Observer {
            //
            val result = it.body()
            val message = it.message()
            val error = it.errorBody()

            if (it.isSuccessful)
            {
                it.body().let { myAdapter.setData(it!!) }

                Log.d("Success", result.toString())
                Log.d("Message", message.toString())
                Log.d("Error", error.toString())
            }

            else
            {
                Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
            }
        })
    }

    private fun showRecyclerView()
    {
        recycler_retrofit.adapter = myAdapter
        recycler_retrofit.layoutManager = LinearLayoutManager(this)
    }
}