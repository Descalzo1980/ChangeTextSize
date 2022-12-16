package ru.stas.myapplication

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.SeekBar
import ru.stas.myapplication.databinding.FragmentToolbarBinding


class ToolbarFragment : Fragment(),SeekBar.OnSeekBarChangeListener {

    private var _binding: FragmentToolbarBinding? = null
    private val binding get() = _binding!!
    var seekvalue = 10
    var activityCallback: ToolbarListener? = null

    interface ToolbarListener{
        fun onButtonClick(position: Int, text: String)
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        try {
            activityCallback = context as ToolbarListener
        }catch (e: ClassCastException){
            throw ClassCastException(context.toString()
            + " must implement ToolbarListener")
        }
    }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentToolbarBinding.inflate(inflater, container, false)
        return binding.root
    }

    @Deprecated("Deprecated in Java")
    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        binding.seekBar1.setOnSeekBarChangeListener(this)
        binding.button1.setOnClickListener { v:View -> buttonClicked(v)}
    }

    private fun buttonClicked(v: View) {
        activityCallback?.onButtonClick(seekvalue,binding.editText1.text.toString())
    }

    override fun onProgressChanged(seekbar: SeekBar, progress: Int, fromUser: Boolean) {
        seekvalue = progress
    }

    override fun onStartTrackingTouch(p0: SeekBar) {

    }

    override fun onStopTrackingTouch(p0: SeekBar) {

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}