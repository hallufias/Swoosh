package com.example.swoosh.Controller

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import com.example.swoosh.Model.Player
import com.example.swoosh.R
import com.example.swoosh.Utilities.EXTRA_PLAYER
import kotlinx.android.synthetic.main.activity_league.*

class LeagueActivity : BaseActivity() {

    //awal kene initialize var player
    var player = Player("","")

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putParcelable(EXTRA_PLAYER, player)
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle?) {
        super.onRestoreInstanceState(savedInstanceState)

        if(savedInstanceState != null){
            player = savedInstanceState.getParcelable(EXTRA_PLAYER)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_league)
    }

    fun onMensClicked(view: View) {
        tgbtnLeagueWomens.isChecked = false
        tgbtnLeagueCoed.isChecked = false

        player.league = "mens"
    }

    fun onWomensClicked(view: View) {
        tgbtnLeagueMens.isChecked = false
        tgbtnLeagueCoed.isChecked = false

        player.league = "womens"
    }

    fun onCoedClicked(view: View) {
        tgbtnLeagueMens.isChecked = false
        tgbtnLeagueWomens.isChecked = false

        player.league = "co-ed"
    }

    fun leagueNextClicked(view: View) {
        if (player.league != "") {
            btnLeagueNext.setOnClickListener {
                val skillIntent = Intent(this, SkillActivity::class.java)
                skillIntent.putExtra(EXTRA_PLAYER, player)

                Log.d(TAG, "leagueNextClicked : $EXTRA_PLAYER")

                startActivity(skillIntent)
            }
        }else{
            Toast.makeText(this, "Please select a league", Toast.LENGTH_SHORT).show()
        }
    }
}
