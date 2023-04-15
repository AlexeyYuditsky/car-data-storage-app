package com.alexeyyuditsky.cardatastorage.presentation.cars

import android.annotation.SuppressLint
import android.app.Activity
import android.app.Dialog
import android.content.DialogInterface
import android.os.Bundle
import android.view.LayoutInflater
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.DialogFragment
import com.alexeyyuditsky.cardatastorage.databinding.DialogCarBinding
import com.github.dhaval2404.imagepicker.ImagePicker

abstract class BaseCarDialogFragment : DialogFragment() {

    private var _binding: DialogCarBinding? = null
    protected val binding get() = _binding!!

    private val imageResult = registerForActivityResult(ActivityResultContracts.StartActivityForResult()) {
        if (it.resultCode == Activity.RESULT_OK) {
            val fileUri = it.data?.data!!
            binding.imageView.tag = fileUri.toString()
            binding.imageView.setImageURI(fileUri)
        }
    }

    protected abstract fun createPositiveListener(): DialogInterface.OnClickListener

    protected abstract fun getTitle(): String

    @SuppressLint("UseGetLayoutInflater")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = DialogCarBinding.inflate(LayoutInflater.from(context))
        setupImageViewListener()
    }

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        return AlertDialog.Builder(requireContext())
            .setTitle(getTitle())
            .setView(binding.root)
            .setNegativeButton(android.R.string.cancel, null)
            .setPositiveButton(android.R.string.ok, createPositiveListener())
            .create()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private fun setupImageViewListener() {
        binding.imageView.setOnClickListener {
            ImagePicker.with(this)
                .galleryOnly()
                .createIntent { intent -> imageResult.launch(intent) }
        }
    }

    companion object {
        const val KEY_ID = "id"
        const val KEY_MODEL = "model"
        const val KEY_COLOR = "color"
        const val KEY_SPEED = "speed"
        const val KEY_HP = "hp"
        const val KEY_IMAGE = "image"
    }

}