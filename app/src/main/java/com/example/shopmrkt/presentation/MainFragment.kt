package com.example.shopmrkt.presentation

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.shopmrkt.R

class MainFragment : Fragment() {

    companion object {
        fun newInstance() = MainFragment()
    }

    private lateinit var viewModel: MainViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return inflater.inflate(R.layout.main_fragment, container, false)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel = ViewModelProvider(this)[MainViewModel::class.java]
        viewModel.shopList.observe(this) {
            Log.d("MainActivityTest", it.toString())
        }
        viewModel.getShopList()
    }

//    class MyFragment : Fragment(), LifecycleObserver {
//        @OnLifecycleEvent(Lifecycle.Event.ON_CREATE)
//        fun onCreated(){
//            activity?.lifecycle?.removeObserver(this)
//        }
// Answer from StOwFl about deprecated some onActCreated

//        override fun onCreate(context: Context) {
//            super.onCreate(context)
//            activity?.lifecycle?.addObserver(this)
//        }
//    }
}