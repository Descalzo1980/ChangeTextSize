package ru.stas.myapplication

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import ru.stas.myapplication.databinding.FragmentTextBinding

class TextFragment: Fragment() {

    private var _binding : FragmentTextBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentTextBinding.inflate(inflater,container,false)
        return binding.root
    }

    fun changeTextProperties(fontsize: Int,text: String){
        binding.textView2.textSize = fontsize.toFloat()
        binding.textView2.text = text
    }
}