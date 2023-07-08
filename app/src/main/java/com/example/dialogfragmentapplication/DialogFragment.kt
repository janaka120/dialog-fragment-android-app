package com.example.dialogfragmentapplication

import android.os.Bundle
import androidx.fragment.app.DialogFragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText

class DialogFragment : DialogFragment() {
    lateinit var name: EditText
    lateinit var age: EditText
    lateinit var ok: Button
    lateinit var cancel: Button


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_dialog, container, false)
        name = view.findViewById(R.id.editTextName)
        age = view.findViewById(R.id.editTextAge)
        ok = view.findViewById(R.id.buttonOk)
        cancel = view.findViewById(R.id.buttonCancel)

        dialog!!.window!!.setBackgroundDrawableResource(android.R.color.transparent)

        ok.setOnClickListener {
            val userName = name.text.toString()
            val userAge = age.text.toString().toInt()

            val mainActivity: MainActivity = activity as MainActivity
            mainActivity.getUserData(userName, userAge)

            dialog!!.dismiss()
        }

        cancel.setOnClickListener {
            dialog!!.dismiss()
        }

        // Inflate the layout for this fragment
        return view
    }
}