package net.solvetheriddle.processing.android.app

import android.content.Intent
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.app.AppCompatActivity
import net.solvetheriddle.processing.android.AndroidApplet
import net.solvetheriddle.processing.android.R
import processing.android.PFragment
import processing.core.PApplet

class MainActivity : AppCompatActivity(),
    SketchListFragment.ActivityCallback {

    private var sketch: PApplet? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)

        val listFragment = SketchListFragment.newInstance(1)
        supportFragmentManager.beginTransaction()
                .add(R.id.content, listFragment)
                .commit()
    }

    override fun onListFragmentInteraction(item: SketchItem) {
        title = item.content
        val genericApplet = item.initializer()
        this.sketch = AndroidApplet(genericApplet)
        val fragment: Fragment = PFragment(this.sketch)
        showFragment(fragment)
    }

    private fun showFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction()
                .add(R.id.content, fragment)
                .addToBackStack(null)
                .commit()
    }

    override fun onRequestPermissionsResult(requestCode: Int, permissions: Array<String>, grantResults: IntArray) {
        if (sketch != null) {
            sketch!!.onRequestPermissionsResult(
                requestCode, permissions, grantResults
            )
        }
    }

    public override fun onNewIntent(intent: Intent) {
        if (sketch != null) {
            sketch!!.onNewIntent(intent)
        }
    }

    override fun onBackPressed() {
        title = getString(R.string.app_name)
        super.onBackPressed()
    }
}
