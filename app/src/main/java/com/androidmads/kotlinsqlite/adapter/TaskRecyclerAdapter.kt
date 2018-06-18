package com.androidmads.kotlinsqlite.adapter

import android.app.LauncherActivity
import android.content.Context
import android.content.Intent
import android.graphics.Color
import android.os.Build
import android.support.annotation.RequiresApi
import android.support.design.widget.Snackbar
import android.support.v4.content.ContextCompat
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.*
import android.widget.*
import com.androidmads.kotlinsqlite.AddOrEditActivity
import com.androidmads.kotlinsqlite.Details

import com.androidmads.kotlinsqlite.R
import com.androidmads.kotlinsqlite.models.Tasks
import kotlinx.android.synthetic.*

import java.util.ArrayList

class TaskRecyclerAdapter(tasksList: List<Tasks>, internal var context: Context) : RecyclerView.Adapter<TaskRecyclerAdapter.TaskViewHolder>(), PopupMenu.OnMenuItemClickListener {
    override fun onMenuItemClick(item: MenuItem?): Boolean {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    internal var tasksList: List<Tasks> = ArrayList()



    init {
        this.tasksList = tasksList

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TaskViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.list_item_tasks, parent, false)
        return TaskViewHolder(view)


    }

    @RequiresApi(Build.VERSION_CODES.JELLY_BEAN)
    override fun onBindViewHolder(holder: TaskViewHolder, position: Int) {
        val tasks = tasksList[position]
        holder.name.text = tasks.name
        holder.desc.text = tasks.desc
        //holder.sn.text = tasks.sn
        if (tasks.completed == "Y")
            holder.list_item.background = ContextCompat.getDrawable(context, R.color.colorSuccess)
        else
            holder.list_item.background = ContextCompat.getDrawable(context, R.color.colorUnSuccess)

        holder.itemView.setOnClickListener {
            val i = Intent(context, Details::class.java)
            i.putExtra("Mode", "E")
            i.putExtra("Id", tasks.id.toString())
            i.putExtra("Id1",tasks.name.toString())
            i.putExtra("Id2",tasks.sn.toString())
            i.putExtra("Id3",tasks.semestre.toString())
            i.putExtra("Id4",tasks.fecha.toString())

            i.flags = Intent.FLAG_ACTIVITY_NEW_TASK
            context.startActivity(i)

        }
        holder.itemView.setOnLongClickListener {
            val i = Intent(context, AddOrEditActivity::class.java)
            i.putExtra("Mode", "E")
            i.putExtra("Id", tasks.id)
            i.flags = Intent.FLAG_ACTIVITY_NEW_TASK
            context.startActivity(i)
            true

        }




       /* holder.itemView.setOnLongClickListener {view ->
            val popup = PopupMenu(view.context,view)
            popup.setOnMenuItemClickListener(this)
            val inflater = popup.menuInflater
            inflater.inflate(R.menu.context_menu, popup.menu)
            popup.show()

            true

        }*/









    }





    override fun getItemCount(): Int {
        return tasksList.size
    }






    inner class TaskViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        var name: TextView = view.findViewById(R.id.tvName) as TextView
        var desc: TextView = view.findViewById(R.id.tvDesc) as TextView
        var list_item: LinearLayout = view.findViewById(R.id.list_item) as LinearLayout
       // var sn: TextView = view.findViewById(R.id.tvSn) as TextView
    }









}
