package com.example.sitask4

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.lifecycleScope
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.launch

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [HomeFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class HomeFragment : Fragment() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home, container, false)
        apiCall("rockyhappy")

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
                } catch (e: Exception) {
                    println(e)
                }

            }
        }
        return service
    }

}