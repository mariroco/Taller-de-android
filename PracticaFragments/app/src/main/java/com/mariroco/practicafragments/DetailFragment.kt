package com.mariroco.practicafragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [DetailFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class DetailFragment : Fragment() {
    private lateinit var imgMain: ImageView
    private lateinit var txtDetail: TextView
    private lateinit var imgFav: ImageView

    //private var param1: String? = null
    //private var param2: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            //param1 = it.getString(ARG_PARAM1)
            //param2 = it.getString(ARG_PARAM2)
        }
    }


    fun initView(){
        imgMain = requireView().findViewById(R.id.img_main)
        txtDetail = requireView().findViewById(R.id.txt_detail)
        imgFav = requireView().findViewById(R.id.img_fav)

        imgMain.setOnClickListener {
           changeFrag()
        }
        imgFav.setOnClickListener {

        }
    }

    fun changeFrag(){
        val frag=ImageFragment.newInstance()
        (activity as MainActivity).replaceFragment(frag,ImageFragment.TAG)
    }
    override fun onStop() {
        super.onStop()
    }

    override fun onDestroy() {
        super.onDestroy()
        (activity as MainActivity?)?.changeVisibility()
    }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_detail, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initView()
    }


    companion object {
        val TAG = DetailFragment::class.java.simpleName
        @JvmStatic
        fun newInstance() = DetailFragment()
    }
}