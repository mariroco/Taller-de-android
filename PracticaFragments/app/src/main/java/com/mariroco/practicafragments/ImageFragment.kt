package com.mariroco.practicafragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

class ImageFragment : Fragment() {
    private lateinit var imageList: List<Image>
    var counter : Int=0
    private lateinit var imgMain: ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_image, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initView()
    }

    fun initView(){
        counter = (activity as MainActivity).counter
        imageList = (activity as MainActivity).imageList
        imgMain=requireView().findViewById(R.id.img_main)
        imgMain.setImageResource(imageList[counter].image)
    }

    companion object {
        val TAG = ImageFragment::class.java.simpleName
        @JvmStatic
        fun newInstance() = ImageFragment()
    }
}