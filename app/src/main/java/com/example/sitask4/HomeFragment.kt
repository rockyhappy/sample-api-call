package com.example.sitask4

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.lifecycle.lifecycleScope
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.launch

class HomeFragment : Fragment() {
    private lateinit var textView: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
//        return inflater.inflate(R.layout.fragment_home, container, false)
        val view = inflater.inflate(R.layout.fragment_home, container, false)
        textView = view.findViewById(R.id.textView)
        apiCall("rockyhappy") // Call the API
        return view


    }

    init {

    }

    fun apiCall(userName: String): UserData {
        var service: UserData =
            UserData("", "", "", null, "", "", "", "", 0, 0, null, null, null, null, null)
        lifecycleScope.launch {
            coroutineScope {
                try {
                    service = RetrofitInstance.api.getUserData(userName)
                    println(service)
                    textView.text = service.toString()
                } catch (e: Exception) {
                    println(e)
                }

            }
        }
        return service
    }

}