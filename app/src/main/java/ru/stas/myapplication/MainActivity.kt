package ru.stas.myapplication

import android.os.Bundle
import androidx.fragment.app.FragmentActivity
import ru.stas.myapplication.databinding.ActivityMainBinding

class MainActivity : FragmentActivity(),ToolbarFragment.ToolbarListener {

    private lateinit var binding : ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

    }

    override fun onButtonClick(position: Int, text: String) {
        val firstFragment = supportFragmentManager.findFragmentById(R.id.fragmentContainerView2) as TextFragment
        firstFragment.changeTextProperties(position,text)
    }
}