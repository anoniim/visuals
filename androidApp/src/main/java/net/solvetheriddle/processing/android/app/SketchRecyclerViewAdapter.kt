package net.solvetheriddle.processing.android.app


import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import net.solvetheriddle.processing.android.app.SketchListFragment.ActivityCallback

/**
 * [RecyclerView.Adapter] that can display a [SketchItem] and makes a call to the
 * specified [ActivityCallback].
 */
class SketchRecyclerViewAdapter(
    private val mValues: List<SketchItem>,
    private val mListener: ActivityCallback?
) : RecyclerView.Adapter<SketchRecyclerViewAdapter.ViewHolder>() {

    private val mOnClickListener: View.OnClickListener

    init {
        mOnClickListener = View.OnClickListener { v ->
            val item = v.tag as SketchItem
            // Notify the active callbacks interface (the activity, if the fragment is attached to
            // one) that an item has been selected.
            mListener?.onListFragmentInteraction(item)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
                .inflate(android.R.layout.simple_list_item_1, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = mValues[position]
//        holder.mIdView.text = item.id
        holder.mContentView.text = item.content

        with(holder.mView) {
            tag = item
            setOnClickListener(mOnClickListener)
        }
    }

    override fun getItemCount(): Int = mValues.size

    inner class ViewHolder(val mView: View) : RecyclerView.ViewHolder(mView) {
//        val mIdView: TextView = mView.item_number
        val mContentView: TextView = mView as TextView

        override fun toString(): String {
            return super.toString() + " '" + mContentView.text + "'"
        }
    }
}
