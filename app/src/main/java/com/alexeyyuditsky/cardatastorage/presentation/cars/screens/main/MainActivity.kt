package com.alexeyyuditsky.cardatastorage.presentation.cars.screens.main

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.commit
import com.alexeyyuditsky.cardatastorage.R
import com.alexeyyuditsky.cardatastorage.core.ResourceProvider
import com.alexeyyuditsky.cardatastorage.core.log
import com.alexeyyuditsky.cardatastorage.presentation.cars.CarUi
import com.alexeyyuditsky.cardatastorage.presentation.cars.FragmentRouter
import com.alexeyyuditsky.cardatastorage.presentation.cars.screens.editcar.EditCarDialogFragment
import com.alexeyyuditsky.cardatastorage.presentation.cars.screens.fullscreencar.FullscreenDialogFragment
import com.alexeyyuditsky.cardatastorage.presentation.cars.screens.newcar.NewCarDialogFragment
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : AppCompatActivity(R.layout.activity_main), FragmentRouter {

    @Inject
    lateinit var result: ResourceProvider

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        if (savedInstanceState == null) {
            supportFragmentManager.commit {
                add(R.id.fragmentContainer, CarsFragment())
            }
        }

        log(result)
    }

    override fun showEditCarDialog(car: CarUi) {
        EditCarDialogFragment.newInstance(car)
            .show(supportFragmentManager, null)
    }

    override fun showNewCarDialog() {
        NewCarDialogFragment.newInstance()
            .show(supportFragmentManager, null)
    }

    override fun showFullscreenDialog(uri: String) {
        FullscreenDialogFragment.newInstance(uri)
            .show(supportFragmentManager, null)
    }

}