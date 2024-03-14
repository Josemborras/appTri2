package com.example.proyecto2trimestre

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.constraintlayout.helper.widget.Carousel.Adapter
import androidx.fragment.app.Fragment
import androidx.navigation.NavDirections
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import com.example.proyecto2trimestre.adaptadores.EquiposAdapter
import com.example.proyecto2trimestre.dataClass.FranNBA
import com.example.proyecto2trimestre.dataClass.Player
import com.example.proyecto2trimestre.databinding.EquiposFragmentBinding

class Equipos : Fragment() {
    private lateinit var binding: EquiposFragmentBinding
    private lateinit var equiposAdapter: Adapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = EquiposFragmentBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val bostonR = listOf(
            Player("Oshae Brissett", "12", "SF", "6-7", "210", "6/20/1998",25, 4),
            Player("Jaylen Brown", "7", "SF", "6-6", "223", "10/24/1996",27, 7),
            Player("JD Davison", "20", "PG", "6-1", "195", "10/3/2002",21, 1),
            Player("Sam Hauser", "30", "SF", "6-7", "217", "12/8/1997",26, 2),
            Player("Jrue Holiday", "4", "PG", "6-4", "205", "6/12/1990", 33,14),
            Player("Al Horford", "42", "C", "6-9", "240", "6/3/1986",37, 16),
            Player("Luke Kornet", "40", "C", "7-1", "250", "7/15/1995",28, 6),
            Player("Svi Mykhailiuk", "50", "SG", "6-7", "205", "6/10/1997", 26,5),
            Player("Drew Peterson", "13", "SF", "6-9", "205", "11/9/1999",24 ,0),
            Player("Kristaps Porzingis", "8", "C", "7-2", "240", "8/2/1995", 28,7),
            Player("Payton Pritchard", "11", "PG", "6-1", "195", "1/28/1998",26, 3),
            Player("Neemias Queta", "88", "C", "7-0", "248", "7/13/1999",24, 2),
            Player("Jaden Springer", "44", "SG", "6-4", "202", "9/25/2002",2, 2),
            Player("Jayson Tatum", "0", "PF", "6-8", "210", "3/3/1998",26, 6),
            Player("Xavier Tillman", "26", "C", "6-7", "245", "1/12/1999",25, 3),
            Player("Jordan Walsh", "27", "SF", "6-7", "205", "3/3/2004",20, 0),
            Player("Derrick White", "9", "SG", "6-4", "190", "7/2/1994",29, 6)
            )
        val atlantaR = listOf(
            Player("Saddiq Bey", "41", "SF", "6-7", "215", "4/9/1999", 24, 3),
            Player("Bogdan Bogdanovic", "13", "SG", "6-5", "225", "8/18/1992", 31, 6),
            Player("Kobe Bufkin", "4", "SG", "6-5", "195", "9/21/2003", 20, 0),
            Player("Clint Capela", "15", "C", "6-10", "256", "5/18/1994", 29, 9),
            Player("Bruno Fernando", "24", "C", "6-9", "240", "8/15/1998", 25, 4),
            Player("Trent Forrest", "2", "SG", "6-4", "210", "6/12/1998", 25, 3),
            Player("AJ Griffin", "14", "SG", "6-6", "220", "8/25/2003", 20, 1),
            Player("Mouhamed Gueye", "18", "PF", "6-10", "210", "11/9/2002", 21, 0),
            Player("De'Andre Hunter", "12", "SF", "6-8", "221", "12/2/1997", 26, 4),
            Player("Jalen Johnson", "1", "SF", "6-8", "219", "12/18/2001", 22, 2),
            Player("Vit Krejci", "27", "SF", "6-8", "195", "6/19/2000", 23, 2),
            Player("Seth Lundy", "3", "SG", "6-6", "220", "4/2/2000", 23, 0),
            Player("Garrison Mathews", "25", "SF", "6-6", "215", "10/24/1996", 27, 4),
            Player("Wesley Matthews", "32", "SG", "6-4", "220", "10/14/1986", 37, 14),
            Player("Dejounte Murray", "5", "PG", "6-5", "180", "9/19/1996", 27, 6),
            Player("Onyeka Okongwu", "17", "C", "6-10", "240", "12/11/2000", 23, 3),
            Player("Dylan Windler", "20", "SG", "6-7", "196", "9/22/1996", 27, 3),
            Player("Trae Young", "11", "PG", "6-1", "164", "9/19/1998", 25, 5)
        )
        val dallasR = listOf(
            Player("Greg Brown", "13", "SF", "6-7", "206", "9/1/2001", 22, 2),
            Player("Luka Doncic", "77", "PG", "6-7", "230", "2/28/1999", 25, 5),
            Player("Dante Exum", "0", "SG", "6-5", "214", "7/13/1995", 28, 6),
            Player("Alex Fudge", "3", "SF", "6-8", "200", "5/6/2003", 20, 0),
            Player("Daniel Gafford", "21", "C", "6-10", "234", "10/1/1998", 25, 4),
            Player("Josh Green", "8", "SF", "6-5", "200", "11/16/2000", 23, 3),
            Player("Tim Hardaway Jr.", "10", "SG", "6-5", "205", "3/16/1992", 31, 10),
            Player("Jaden Hardy", "1", "SG", "6-3", "198", "7/5/2002", 21, 1),
            Player("Kyrie Irving", "11", "PG", "6-2", "195", "3/23/1992", 31, 12),
            Player("Derrick Jones Jr.", "55", "SF", "6-6", "210", "2/15/1997", 27, 7),
            Player("Maxi Kleber", "42", "C", "6-10", "240", "1/29/1992", 32, 6),
            Player("AJ Lawson", "9", "SG", "6-6", "179", "7/15/2000", 23, 1),
            Player("Dereck Lively II", "2", "C", "7-1", "230", "2/12/2004", 20, 0),
            Player("Markieff Morris", "88", "PF", "6-9", "245", "9/2/1989", 34, 12),
            Player("Dwight Powell", "7", "C", "6-10", "240", "7/20/1991", 32, 9),
            Player("Olivier-Maxence Prosper", "18", "SF", "6-7", "230", "7/3/2002", 21, 0),
            Player("PJ Washington", "25", "PF", "6-7", "230", "8/23/1998", 25, 4),
            Player("Brandon Williams", "00", "PG", "6-2", "190", "11/22/1999", 24, 1)
        )
        val brooklynR = listOf(
            Player("Keita Bates-Diop", "13", "SF", "6-8", "229", "1/23/1996", 28, 5),
            Player("Mikal Bridges", "1", "SF", "6-6", "209", "8/30/1996", 27, 5),
            Player("Nicolas Claxton", "33", "C", "6-11", "215", "4/17/1999", 24, 4),
            Player("Noah Clowney", "21", "PF", "6-9", "210", "7/14/2004", 19, 0),
            Player("Dorian Finney-Smith", "28", "PF", "6-7", "220", "5/4/1993", 30, 7),
            Player("Jacob Gilyard", "14", "PG", "5-8", "160", "7/14/1998", 25, 1),
            Player("Cameron Johnson", "2", "SF", "6-8", "210", "3/3/1996", 28, 4),
            Player("Keon Johnson", "45", "SG", "6-4", "185", "3/10/2002", 22, 2),
            Player("Jaylen Martin", "16", "SG", "6-6", "216", "1/28/2004", 20, 0),
            Player("Dennis Schroder", "17", "PG", "6-1", "172", "9/15/1993", 30, 10),
            Player("Day'Ron Sharpe", "20", "C", "6-9", "265", "11/6/2001", 22, 2),
            Player("Ben Simmons", "10", "PG", "6-10", "240", "7/20/1996", 27, 5),
            Player("Dennis Smith Jr.", "4", "PG", "6-3", "205", "11/25/1997", 26, 6),
            Player("Cameron Thomas", "24", "SG", "6-3", "210", "10/13/2001", 22, 2),
            Player("Lonnie Walker IV", "8", "SG", "6-4", "204", "12/14/1998", 25, 5),
            Player("Trendon Watford", "9", "PF", "6-8", "237", "11/9/2000", 23, 2),
            Player("Dariq Whitehead", "0", "SG", "6-6", "220", "8/1/2004", 19, 0),
            Player("Jalen Wilson", "22", "SF", "6-6", "220", "11/4/2000", 23, 0)
        )
        val newyorkR = listOf(
            Player("Precious Achiuwa", "5", "PF", "6-8", "225", "9/19/1999", 24, 3),
            Player("OG Anunoby", "8", "SF", "6-7", "232", "7/17/1997", 26, 6),
            Player("Bojan Bogdanovic", "44", "SF", "6-7", "226", "4/18/1989", 34, 9),
            Player("Charlie Brown", "4", "SG", "6-6", "199", "2/2/1997", 27, 3),
            Player("Jalen Brunson", "11", "PG", "6-2", "190", "8/31/1996", 27, 5),
            Player("Alec Burks", "18", "PG", "6-5", "214", "7/20/1991", 32, 12),
            Player("Donte DiVincenzo", "0", "SG", "6-4", "203", "1/31/1997", 27, 5),
            Player("Josh Hart", "3", "SF", "6-4", "215", "3/6/1995", 29, 6),
            Player("Isaiah Hartenstein", "55", "C", "7-0", "250", "5/5/1998", 25, 5),
            Player("DaQuan Jeffries", "8", "SG", "6-5", "220", "8/30/1997", 26, 4),
            Player("Miles McBride", "2", "PG", "6-1", "195", "9/8/2000", 23, 2),
            Player("Shake Milton", "13", "SG", "6-5", "205", "9/26/1996", 27, 5),
            Player("Julius Randle", "30", "PF", "6-8", "250", "11/29/1994", 29, 9),
            Player("Mitchell Robinson", "23", "C", "7-0", "240", "4/1/1998", 25, 5),
            Player("Jericho Sims", "45", "C", "6-10", "250", "10/20/1998", 25, 2),
            Player("Dmytro Skapintsev", "30", "C", "7-1", "215", "5/12/1998", 25, 0),
            Player("Jacob Toppin", "00", "SF", "6-8", "200", "5/8/2000", 23, 0),
            Player("Duane Washington Jr.", "4", "PG", "6-3", "197", "3/24/2000", 23, 2)
        )
        val sixersR = listOf(
            Player("Mo Bamba", "5", "C", "7-0", "231", "5/12/1998", 25, 5),
            Player("Nicolas Batum", "40", "PF", "6-8", "230", "12/14/1988", 35, 15),
            Player("Ricky Council IV", "16", "SG", "6-6", "205", "8/3/2001", 22, 0),
            Player("Robert Covington", "33", "PF", "6-7", "209", "12/14/1990", 33, 10),
            Player("Jeff Dowtin", "", "PG", "6-3", "177", "5/10/1997", 26, 2),
            Player("Joel Embiid", "21", "C", "7-0", "280", "3/16/1994", 29, 7),
            Player("Tobias Harris", "12", "PF", "6-8", "226", "7/15/1992", 31, 12),
            Player("Buddy Hield", "17", "SF", "6-4", "220", "12/17/1992", 31, 7),
            Player("Kyle Lowry", "7", "PG", "6-0", "196", "3/25/1986", 37, 17),
            Player("Kenyon Martin Jr.", "1", "SF", "6-6", "215", "1/6/2001", 23, 3),
            Player("Tyrese Maxey", "0", "PG", "6-2", "200", "11/4/2000", 23, 3),
            Player("De'Anthony Melton", "8", "SG", "6-3", "200", "5/28/1998", 25, 5),
            Player("Kelly Oubre Jr.", "9", "SG", "6-7", "203", "12/9/1995", 28, 8),
            Player("Cameron Payne", "22", "PG", "6-3", "183", "8/8/1994", 29, 8),
            Player("Paul Reed", "44", "C", "6-9", "210", "6/14/1999", 24, 3),
            Player("Terquavion Smith", "23", "SG", "6-4", "160", "12/31/2002", 21, 0)
        )
        val raptorsR = listOf(
            Player("Ochai Agbaji", "30", "SF", "6-5", "215", "4/20/2000", 23, 1),
            Player("Scottie Barnes", "4", "SG", "6-7", "225", "8/1/2001", 22, 2),
            Player("RJ Barrett", "9", "SF", "6-6", "214", "6/14/2000", 23, 4),
            Player("Chris Boucher", "25", "C", "6-9", "200", "1/11/1993", 31, 6),
            Player("Bruce Brown", "11", "SG", "6-4", "202", "8/15/1996", 27, 5),
            Player("D.J. Carton", "3", "PG", "6-3", "200", "8/5/2000", 23, 0),
            Player("Gradey Dick", "1", "SG", "6-6", "205", "11/20/2003", 20, 0),
            Player("Javon Freeman-Liberty", "0", "SG", "6-3", "180", "10/20/1999", 24, 0),
            Player("Mouhamadou Gueye", "16", "SF", "6-9", "210", "7/6/1998", 25, 0),
            Player("Jalen McDaniels", "2", "PF", "6-9", "205", "1/31/1998", 26, 4),
            Player("Jordan Nwora", "13", "SG", "6-8", "220", "9/9/1998", 25, 3),
            Player("Kelly Olynyk", "41", "PF", "6-11", "240", "4/19/1991", 32, 10),
            Player("Jakob Poeltl", "19", "C", "7-0", "245", "10/15/1995", 28, 7),
            Player("Jontay Porter", "34", "C", "6-11", "240", "11/15/1999", 24, 1),
            Player("Immanuel Quickley", "5", "PG", "6-3", "190", "6/17/1999", 24, 3),
            Player("Jahmi'us Ramsey", "37", "SG", "6-3", "190", "6/9/2001", 22, 2),
            Player("Garrett Temple", "14", "SF", "6-5", "195", "5/8/1986", 37, 13),
            Player("Gary Trent Jr.", "33", "SG", "6-5", "209", "1/18/1999", 25, 5),
            Player("Justise Winslow", "", "SG", "6-6", "222", "3/26/1996", 27, 8)
        )
        val nuggetsR = listOf(
            Player("Christian Braun", "0", "SF", "6-6", "220", "4/17/2001", 22, 1),
            Player("Kentavious Caldwell-Pope", "5", "SG", "6-5", "204", "2/18/1993", 31, 10),
            Player("Vlatko Cancar", "31", "SF", "6-8", "236", "4/10/1997", 26, 4),
            Player("Collin Gillespie", "21", "PG", "6-1", "195", "6/25/1999", 24, 0),
            Player("Aaron Gordon", "50", "PF", "6-8", "235", "9/16/1995", 28, 9),
            Player("Justin Holiday", "9", "SF", "6-6", "180", "4/5/1989", 34, 10),
            Player("Jay Huff", "30", "C", "7-1", "240", "8/25/1998", 25, 2),
            Player("Reggie Jackson", "7", "PG", "6-2", "208", "4/16/1990", 33, 12),
            Player("Nikola Jokic", "15", "C", "6-11", "284", "2/19/1995", 29, 8),
            Player("DeAndre Jordan", "6", "C", "6-11", "265", "7/21/1988", 35, 15),
            Player("Braxton Key", "11", "SF", "6-8", "225", "2/14/1997", 27, 2),
            Player("Jamal Murray", "27", "PG", "6-4", "215", "2/23/1997", 27, 6),
            Player("Zeke Nnaji", "22", "PF", "6-9", "240", "1/9/2001", 23, 3),
            Player("Jalen Pickett", "24", "SG", "6-2", "202", "10/22/1999", 24, 0),
            Player("Michael Porter Jr.", "1", "SF", "6-10", "218", "6/29/1998", 25, 4),
            Player("Julian Strawther", "3", "SF", "6-6", "205", "4/18/2002", 21, 0),
            Player("Hunter Tyson", "4", "SF", "6-8", "215", "6/13/2000", 23, 0),
            Player("Peyton Watson", "8", "SF", "6-7", "200", "9/11/2002", 21, 1)
        )
        val timberwolvesR = listOf(
            Player("Nickeil Alexander-Walker", "9", "SF", "6-5", "205", "9/2/1998", 25, 4),
            Player("Kyle Anderson", "1", "SF", "6-9", "230", "9/20/1993", 30, 9),
            Player("Jaylen Clark", "0", "SG", "6-4", "205", "10/13/2001", 22, 0),
            Player("Mike Conley", "10", "PG", "6-0", "175", "10/11/1987", 36, 16),
            Player("Anthony Edwards", "5", "SG", "6-4", "225", "8/5/2001", 22, 3),
            Player("Luka Garza", "55", "PF", "6-10", "243", "12/27/1998", 25, 2),
            Player("Rudy Gobert", "27", "C", "7-1", "258", "6/26/1992", 31, 10),
            Player("Justin Jackson", "-", "SF", "6-8", "220", "3/28/1995", 28, 6),
            Player("Jaden McDaniels", "3", "SF", "6-9", "185", "9/29/2000", 23, 3),
            Player("Jordan McLaughlin", "6", "PG", "6-0", "185", "4/9/1996", 27, 4),
            Player("Leonard Miller", "33", "SF", "6-10", "210", "11/26/2003", 20, 0),
            Player("Josh Minott", "8", "SF", "6-8", "205", "11/25/2002", 21, 1),
            Player("Wendell Moore Jr.", "7", "SG", "6-5", "215", "9/18/2001", 22, 1),
            Player("Monte Morris", "23", "PG", "6-2", "183", "6/27/1995", 28, 6),
            Player("Daishen Nix", "12", "PG", "6-3", "226", "2/13/2002", 22, 2),
            Player("Naz Reid", "11", "C", "6-9", "264", "8/26/1999", 24, 4),
            Player("Karl-Anthony Towns", "32", "PF", "7-0", "248", "11/15/1995", 28, 8),
            Player("T.J. Warren", "24", "SF", "6-8", "220", "9/5/1993", 30, 8)
        )
        val thunderR = listOf(
            Player("Bismack Biyombo", "15", "C", "6-8", "255", "8/28/1992", 31, 12),
            Player("Ousmane Dieng", "13", "SF", "6-9", "185", "5/21/2003", 20, 1),
            Player("Luguentz Dort", "5", "SF", "6-4", "220", "4/19/1999", 24, 4),
            Player("Adam Flagler", "14", "SG", "6-3", "195", "12/1/1999", 24, 0),
            Player("Josh Giddey", "3", "PG", "6-8", "216", "10/10/2002", 21, 2),
            Player("Shai Gilgeous-Alexander", "2", "SG", "6-6", "195", "7/12/1998", 25, 5),
            Player("Gordon Hayward", "33", "SF", "6-7", "225", "3/23/1990", 33, 13),
            Player("Chet Holmgren", "7", "C", "7-1", "195", "5/1/2002", 21, 0),
            Player("Isaiah Joe", "11", "SG", "6-3", "165", "7/2/1999", 24, 3),
            Player("Keyontae Johnson", "18", "SF", "6-4", "230", "5/24/2000", 23, 0),
            Player("Mike Muscala", "50", "C", "6-10", "240", "7/1/1991", 32, 10),
            Player("Olivier Sarr", "30", "C", "6-10", "240", "2/20/1999", 25, 2),
            Player("Cason Wallace", "22", "PG", "6-3", "195", "11/7/2003", 20, 0),
            Player("Lindy Waters III", "12", "SG", "6-6", "210", "7/28/1997", 26, 2),
            Player("Aaron Wiggins", "21", "SG", "6-5", "190", "1/2/1999", 25, 2),
            Player("Kenrich Williams", "34", "SG", "6-6", "210", "12/2/1994", 29, 5),
            Player("Jalen Williams", "8", "SF", "6-5", "211", "4/14/2001", 22, 1),
            Player("Jaylin Williams", "6", "PF", "6-9", "240", "6/29/2002", 21, 1)
        )
        val sunsR = listOf(
            Player("Deandre Ayton", "2", "C", "7-0", "250", "7/23/1998", 25, 5),
            Player("Ibou Badji", "41", "C", "7-2", "230", "10/13/2002", 21, 0),
            Player("Dalano Banton", "5", "PG", "6-8", "204", "11/7/1999", 24, 2),
            Player("Malcolm Brogdon", "11", "PG", "6-4", "229", "12/11/1992", 31, 7),
            Player("Moses Brown", "10", "C", "7-2", "245", "10/13/1999", 24, 4),
            Player("Toumani Camara", "33", "SF", "6-7", "220", "5/8/2000", 23, 0),
            Player("Jerami Grant", "9", "PF", "6-7", "210", "3/12/1994", 30, 9),
            Player("Ashton Hagans", "22", "PG", "6-3", "190", "7/8/1999", 24, 1),
            Player("Scoot Henderson", "00", "PG", "6-3", "195", "2/3/2004", 20, 0),
            Player("Justin Minaya", "24", "SF", "6-5", "210", "3/26/1999", 24, 1),
            Player("Kris Murray", "8", "PF", "6-8", "220", "8/19/2000", 23, 0),
            Player("Duop Reath", "26", "C", "6-9", "245", "6/26/1996", 27, 0),
            Player("Rayan Rupert", "72", "SG", "6-6", "185", "5/31/2004", 19, 0),
            Player("Shaedon Sharpe", "17", "SG", "6-5", "200", "5/30/2003", 20, 1),
            Player("Anfernee Simons", "1", "SG", "6-3", "181", "6/8/1999", 24, 5),
            Player("Matisse Thybulle", "4", "SF", "6-5", "201", "3/4/1997", 27, 4),
            Player("Jabari Walker", "34", "PF", "6-7", "200", "7/30/2002", 21, 1),
            Player("Robert Williams III", "35", "C", "6-9", "237", "10/17/1997", 26, 5)
        )
        val utahR = listOf(
            Player("Darius Bazley", "—", "PF", "6-8", "208", "6/12/2000", 23, 4),
            Player("Jordan Clarkson", "00", "PG", "6-3", "194", "6/7/1992", 31, 9),
            Player("John Collins", "20", "C", "6-9", "226", "9/23/1997", 26, 6),
            Player("Kris Dunn", "11", "PG", "6-3", "205", "3/18/1994", 29, 7),
            Player("Keyonte George", "3", "SG", "6-4", "185", "11/8/2003", 20, 0),
            Player("Taylor Hendricks", "0", "PF", "6-9", "215", "11/22/2003", 20, 0),
            Player("Talen Horton-Tucker", "5", "SG", "6-4", "234", "11/25/2000", 23, 4),
            Player("Johnny Juzang", "33", "SG", "6-5", "209", "3/17/2001", 22, 1),
            Player("Walker Kessler", "24", "C", "7-0", "245", "7/26/2001", 22, 1),
            Player("Taevion Kinsey", "22", "SG", "6-5", "190", "3/10/2000", 24, 0),
            Player("Kira Lewis Jr.", "13", "PG", "6-1", "170", "4/6/2001", 22, 3),
            Player("Kenneth Lofton Jr.", "34", "PF", "6-6", "275", "8/14/2002", 21, 1),
            Player("Lauri Markkanen", "23", "PF", "7-0", "240", "5/22/1997", 26, 6),
            Player("Micah Potter", "25", "PF", "6-9", "248", "4/6/1998", 25, 2),
            Player("Jason Preston", "10", "PG", "6-3", "181", "8/10/1999", 24, 1),
            Player("Luka Samanic", "19", "PF", "6-10", "227", "1/9/2000", 24, 3),
            Player("Brice Sensabaugh", "8", "SG", "6-5", "235", "10/30/2003", 20, 0),
            Player("Collin Sexton", "2", "SG", "6-3", "190", "1/4/1999", 25, 5),
            Player("Omer Yurtseven", "77", "C", "6-11", "275", "6/19/1998", 25, 2)
        )
        val chicacgoR = listOf(
            Player("Lonzo Ball", "2", "PG", "6-6", "190", "10/27/1997", 26, 5),
            Player("Onuralp Bitim", "17", "SF", "6-6", "215", "3/31/1999", 24, 0),
            Player("Jevon Carter", "5", "PG", "6-1", "200", "9/14/1995", 28, 5),
            Player("Alex Caruso", "6", "SG", "6-5", "186", "2/28/1994", 30, 6),
            Player("Torrey Craig", "13", "SF", "6-5", "221", "12/19/1990", 33, 6),
            Player("DeMar DeRozan", "11", "SF", "6-6", "220", "8/7/1989", 34, 14),
            Player("Ayo Dosunmu", "12", "PG", "6-5", "200", "1/17/2000", 24, 2),
            Player("Henri Drell", "77", "SF", "6-9", "215", "4/25/2000", 23, 0),
            Player("Andre Drummond", "3", "C", "6-11", "279", "8/10/1993", 30, 11),
            Player("Andrew Funk", "—", "SG", "6-5", "200", "9/21/1999", 24, 0),
            Player("Zach LaVine", "8", "SG", "6-5", "200", "3/10/1995", 29, 9),
            Player("Julian Phillips", "15", "SF", "6-8", "197", "11/5/2003", 20, 0),
            Player("Adama Sanogo", "21", "C", "6-9", "245", "2/12/2002", 22, 0),
            Player("Terry Taylor", "32", "SF", "6-4", "230", "9/23/1999", 24, 2),
            Player("Dalen Terry", "25", "SG", "6-7", "195", "7/12/2002", 21, 1),
            Player("Nikola Vucevic", "9", "C", "6-10", "260", "10/24/1990", 33, 12),
            Player("Coby White", "0", "PG", "6-5", "195", "2/16/2000", 24, 4),
            Player("Patrick Williams", "44", "PF", "6-7", "215", "8/26/2001", 22, 3)
        )
        val clevelandR = listOf(
            Player("Jarrett Allen", "31", "C", "6-9", "243", "4/21/1998", 25, 6),
            Player("Emoni Bates", "21", "SF", "6-8", "170", "1/28/2004", 20, 0),
            Player("Sharife Cooper", "00", "PG", "6-1", "180", "6/11/2001", 22, 1),
            Player("Darius Garland", "10", "PG", "6-1", "192", "1/26/2000", 24, 4),
            Player("Ty Jerome", "2", "SG", "6-5", "195", "7/8/1997", 26, 4),
            Player("Damian Jones", "30", "C", "6-10", "245", "6/30/1995", 28, 7),
            Player("Caris LeVert", "3", "SG", "6-6", "205", "8/25/1994", 29, 7),
            Player("Sam Merrill", "5", "SG", "6-4", "205", "5/15/1996", 27, 3),
            Player("Donovan Mitchell", "45", "SG", "6-3", "215", "9/7/1996", 27, 6),
            Player("Evan Mobley", "4", "PF", "6-11", "215", "6/18/2001", 22, 2),
            Player("Isaiah Mobley", "15", "PF", "6-8", "238", "9/24/1999", 24, 1),
            Player("Pete Nance", "8", "PF", "6-11", "230", "2/19/2000", 24, 0),
            Player("Georges Niang", "20", "PF", "6-7", "230", "6/17/1993", 30, 7),
            Player("Isaac Okoro", "35", "SF", "6-5", "225", "1/26/2001", 23, 3),
            Player("Craig Porter Jr.", "9", "PG", "6-1", "180", "2/26/2000", 24, 0),
            Player("Zhaire Smith", "19", "SG", "6-3", "205", "6/4/1999", 24, 2),
            Player("Max Strus", "1", "SG", "6-5", "215", "3/28/1996", 27, 4),
            Player("Dean Wade", "32", "PF", "6-9", "228", "11/20/1996", 27, 4)
        )
        val pistonsR = listOf(
            Player("Buddy Boeheim", "27", "SG", "6-6", "205", "11/11/1999", 24, 1),
            Player("Troy Brown Jr.", "7", "SG", "6-7", "215", "7/28/1999", 24, 5),
            Player("Cade Cunningham", "2", "SG", "6-6", "220", "9/25/2001", 22, 2),
            Player("Jalen Duren", "0", "C", "6-10", "250", "11/18/2003", 20, 1),
            Player("Tosan Evbuomwan", "18", "SF", "6-7", "217", "2/16/2001", 23, 0),
            Player("Malachi Flynn", "18", "PG", "6-1", "175", "5/9/1998", 25, 3),
            Player("Simone Fontecchio", "19", "SF", "6-7", "209", "12/9/1995", 28, 1),
            Player("Evan Fournier", "31", "SG", "6-6", "205", "10/29/1992", 31, 11),
            Player("Taj Gibson", "67", "C", "6-9", "232", "6/24/1985", 38, 14),
            Player("Quentin Grimes", "24", "SG", "6-5", "210", "5/8/2000", 23, 2),
            Player("Jaden Ivey", "23", "SG", "6-4", "195", "2/13/2002", 22, 1),
            Player("Jared Rhoden", "8", "SG", "6-5", "210", "8/27/1999", 24, 1),
            Player("Marcus Sasser", "25", "PG", "6-2", "195", "9/21/2000", 23, 0),
            Player("Isaiah Stewart", "28", "PF", "6-8", "250", "5/22/2001", 22, 3),
            Player("Ausar Thompson", "9", "SF", "6-6", "205", "1/30/2003", 21, 0),
            Player("Stanley Umude", "17", "SG", "6-6", "210", "4/12/1999", 24, 1),
            Player("James Wiseman", "13", "C", "6-11", "240", "3/31/2001", 22, 2)
        )
        val pacersR = listOf(
            Player("Kendall Brown", "10", "SF", "6-7", "205", "5/11/2003", 20, 1),
            Player("Tyrese Haliburton", "0", "PG", "6-5", "185", "2/29/2000", 24, 3),
            Player("Isaiah Jackson", "22", "C", "6-9", "205", "1/10/2002", 22, 2),
            Player("Quenton Jackson", "29", "SG", "6-5", "173", "9/15/1998", 25, 1),
            Player("James Johnson", "16", "PF", "6-7", "240", "2/20/1987", 37, 14),
            Player("Bennedict Mathurin", "00", "SF", "6-5", "210", "6/19/2002", 21, 1),
            Player("T.J. McConnell", "9", "PG", "6-1", "190", "3/25/1992", 31, 8),
            Player("Doug McDermott", "20", "SF", "6-6", "225", "1/3/1992", 32, 9),
            Player("Andrew Nembhard", "2", "PG", "6-4", "191", "1/16/2000", 24, 1),
            Player("Aaron Nesmith", "23", "SF", "6-6", "215", "10/16/1999", 24, 3),
            Player("Ben Sheppard", "26", "SG", "6-6", "190", "7/16/2001", 22, 0),
            Player("Pascal Siakam", "43", "PF", "6-8", "230", "4/2/1994", 29, 7),
            Player("Jalen Smith", "25", "PF", "6-9", "215", "3/16/2000", 23, 3),
            Player("Obi Toppin", "1", "PF", "6-9", "220", "3/4/1998", 26, 3),
            Player("Oscar Tshiebwe", "44", "PF", "6-8", "255", "11/27/1999", 24, 0),
            Player("Myles Turner", "33", "C", "6-11", "250", "3/24/1996", 27, 8),
            Player("Jarace Walker", "5", "PF", "6-7", "235", "9/4/2003", 20, 0),
            Player("Isaiah Wong", "21", "PG", "6-3", "185", "1/28/2001", 23, 0)
        )
        val bucksR = listOf(
            Player("Giannis Antetokounmpo", "34", "PF", "6-11", "242", "12/6/1994", 29, 10),
            Player("Thanasis Antetokounmpo", "43", "PF", "6-7", "219", "7/18/1992", 31, 5),
            Player("Malik Beasley", "5", "SG", "6-4", "187", "11/26/1996", 27, 7),
            Player("MarJon Beauchamp", "3", "SG", "6-7", "199", "10/12/2000", 23, 1),
            Player("Patrick Beverley", "21", "PG", "6-2", "180", "7/12/1988", 35, 11),
            Player("Pat Connaughton", "24", "SG", "6-5", "209", "1/6/1993", 31, 8),
            Player("Jae Crowder", "99", "PF", "6-6", "235", "7/6/1990", 33, 11),
            Player("Danilo Gallinari", "12", "PF", "6-10", "236", "8/8/1988", 35, 13),
            Player("Jaylin Galloway", "00", "SF", "6-7", "190", "12/21/2002", 21, 0),
            Player("AJ Green", "20", "SG", "6-4", "190", "9/27/1999", 24, 1),
            Player("Andre Jackson Jr.", "44", "SF", "6-6", "209", "11/13/2001", 22, 0),
            Player("Damian Lillard", "0", "PG", "6-2", "195", "7/15/1990", 33, 11),
            Player("Chris Livingston", "7", "SF", "6-6", "220", "10/15/2003", 20, 0),
            Player("Brook Lopez", "11", "C", "7-1", "282", "4/1/1988", 35, 15),
            Player("Khris Middleton", "22", "SF", "6-7", "222", "8/12/1991", 32, 11),
            Player("Bobby Portis", "9", "PF", "6-10", "250", "2/10/1995", 29, 8),
            Player("Ryan Rollins", "55", "SG", "6-3", "180", "7/3/2002", 21, 1),
            Player("TyTy Washington Jr.", "23", "PG", "6-3", "195", "11/15/2001", 22, 1)
        )
        val warriorsR = listOf(
            Player("Stephen Curry", "30", "PG", "6-2", "185", "3/14/1988", 35, 14),
            Player("Usman Garuba", "12", "PF", "6-8", "229", "3/9/2002", 22, 2),
            Player("Draymond Green", "23", "PF", "6-6", "230", "3/4/1990", 34, 11),
            Player("Trayce Jackson-Davis", "32", "C", "6-9", "245", "2/22/2000", 24, 0),
            Player("Jonathan Kuminga", "00", "PF", "6-7", "225", "10/6/2002", 21, 2),
            Player("Kevon Looney", "5", "C", "6-9", "222", "2/6/1996", 28, 8),
            Player("Moses Moody", "4", "SF", "6-5", "211", "5/31/2002", 21, 2),
            Player("Chris Paul", "3", "PG", "6-0", "175", "5/6/1985", 38, 18),
            Player("Gary Payton II", "0", "PG", "6-2", "195", "12/1/1992", 31, 7),
            Player("Brandin Podziemski", "2", "SG", "6-4", "205", "2/25/2003", 21, 0),
            Player("Lester Quinones", "25", "SG", "6-4", "208", "11/16/2000", 23, 1),
            Player("Jerome Robinson", "18", "SG", "6-5", "190", "2/22/1997", 27, 3),
            Player("Gui Santos", "15", "SF", "6-8", "220", "6/22/2002", 21, 0),
            Player("Dario Saric", "20", "PF", "6-10", "225", "4/8/1994", 29, 6),
            Player("Pat Spencer", "61", "PG", "6-3", "205", "7/4/1996", 27, 0),
            Player("Klay Thompson", "11", "SG", "6-6", "220", "2/8/1990", 34, 10),
            Player("Andrew Wiggins", "22", "SF", "6-7", "197", "2/23/1995", 29, 9)
        )
        val clippersR = listOf(
            Player("Brandon Boston Jr.", "4", "SG", "6-6", "188", "11/28/2001", 22, 2),
            Player("Kobe Brown", "21", "SF", "6-7", "252", "1/1/2000", 24, 0),
            Player("Amir Coffey", "7", "SF", "6-7", "210", "6/17/1997", 26, 4),
            Player("Moussa Diabate", "25", "PF", "6-10", "210", "1/21/2002", 22, 1),
            Player("Paul George", "13", "SF", "6-8", "220", "5/2/1990", 33, 13),
            Player("James Harden", "1", "PG", "6-5", "220", "8/26/1989", 34, 14),
            Player("Bones Hyland", "5", "PG", "6-2", "169", "9/14/2000", 23, 2),
            Player("Kawhi Leonard", "2", "SF", "6-7", "225", "6/29/1991", 32, 11),
            Player("Terance Mann", "14", "SG", "6-5", "215", "10/18/1996", 27, 4),
            Player("Jordan Miller", "11", "SF", "6-5", "194", "1/23/2000", 24, 0),
            Player("Xavier Moon", "22", "SG", "6-2", "165", "1/2/1995", 29, 2),
            Player("Mason Plumlee", "44", "C", "6-10", "254", "3/5/1990", 34, 10),
            Player("Norman Powell", "24", "SG", "6-4", "215", "5/25/1993", 30, 8),
            Player("Joshua Primo", "12", "SG", "6-4", "189", "12/24/2002", 21, 2),
            Player("Daniel Theis", "10", "C", "6-8", "245", "4/4/1992", 31, 6),
            Player("P.J. Tucker", "17", "PF", "6-5", "245", "5/5/1985", 38, 12),
            Player("Russell Westbrook", "0", "PG", "6-4", "200", "11/12/1988", 35, 15),
            Player("Ivica Zubac", "40", "C", "7-0", "240", "3/18/1997", 26, 7)
        )
        val lakersR = listOf(
            Player("Colin Castleton", "14", "C", "6-10", "250", "5/25/2000", 23, 0),
            Player("Max Christie", "10", "SG", "6-5", "190", "2/10/2003", 21, 1),
            Player("Anthony Davis", "3", "C", "6-10", "253", "3/11/1993", 31, 11),
            Player("Spencer Dinwiddie", "26", "PG", "6-5", "215", "4/6/1993", 30, 9),
            Player("Harry Giles III", "20", "PF", "6-10", "240", "4/22/1998", 25, 3),
            Player("Rui Hachimura", "28", "PF", "6-8", "230", "2/8/1998", 26, 4),
            Player("Jaxson Hayes", "11", "C", "7-0", "220", "5/23/2000", 23, 4),
            Player("Jalen Hood-Schifino", "0", "SG", "6-5", "215", "6/19/2003", 20, 0),
            Player("LeBron James", "23", "SF", "6-9", "250", "12/30/1984", 39, 20),
            Player("Maxwell Lewis", "21", "SF", "6-7", "195", "7/27/2002", 21, 0),
            Player("Skylar Mays", "—", "SG", "6-4", "205", "9/5/1997", 26, 3),
            Player("Taurean Prince", "12", "SG", "6-6", "218", "3/22/1994", 29, 7),
            Player("Austin Reaves", "15", "SG", "6-5", "197", "5/29/1998", 25, 2),
            Player("Cam Reddish", "5", "SF", "6-7", "217", "9/1/1999", 24, 4),
            Player("D'Angelo Russell", "1", "PG", "6-3", "193", "2/23/1996", 28, 8),
            Player("Jarred Vanderbilt", "2", "PF", "6-8", "214", "4/3/1999", 24, 5),
            Player("Gabe Vincent", "7", "PG", "6-2", "200", "6/14/1996", 27, 4),
            Player("Christian Wood", "35", "PF", "6-8", "214", "9/27/1995", 28, 7)
        )
        val kingsR = listOf(
            Player("Harrison Barnes", "40", "PF", "6-8", "225", "5/30/1992", 31, 11),
            Player("Chris Duarte", "3", "SG", "6-5", "190", "6/13/1997", 26, 2),
            Player("Kessler Edwards", "17", "SF", "6-7", "203", "8/9/2000", 23, 2),
            Player("Keon Ellis", "23", "SG", "6-3", "175", "1/8/2000", 24, 1),
            Player("Jordan Ford", "31", "PG", "6-1", "175", "5/26/1998", 25, 0),
            Player("De'Aaron Fox", "5", "PG", "6-3", "185", "12/20/1997", 26, 6),
            Player("Kevin Huerter", "9", "SG", "6-7", "198", "8/27/1998", 25, 5),
            Player("Colby Jones", "20", "SG", "6-6", "207", "5/28/2002", 21, 0),
            Player("Mason Jones", "22", "SG", "6-4", "200", "7/21/1998", 25, 2),
            Player("Alex Len", "25", "C", "7-0", "250", "6/16/1993", 30, 10),
            Player("Trey Lyles", "41", "PF", "6-9", "234", "11/5/1995", 28, 8),
            Player("JaVale McGee", "00", "C", "7-0", "270", "1/19/1988", 36, 15),
            Player("Davion Mitchell", "15", "PG", "6-0", "202", "9/5/1998", 25, 2),
            Player("Malik Monk", "0", "SG", "6-3", "200", "2/4/1998", 26, 6),
            Player("Keegan Murray", "13", "PF", "6-8", "225", "8/19/2000", 23, 1),
            Player("Domantas Sabonis", "10", "C", "6-10", "240", "5/3/1996", 27, 7),
            Player("Jalen Slawson", "18", "SF", "6-7", "215", "10/22/1999", 24, 0),
            Player("Sasha Vezenkov", "7", "PF", "6-8", "225", "8/6/1995", 28, 0)
        )
        val hornetsR = listOf(
            Player("Amari Bailey", "10", "SG", "6-3", "185", "2/17/2004", 20, 0),
            Player("LaMelo Ball", "1", "PG", "6-7", "180", "8/22/2001", 22, 3),
            Player("Davis Bertans", "9", "SF", "6-10", "225", "11/12/1992", 31, 7),
            Player("Leaky Black", "12", "SF", "6-6", "209", "6/14/1999", 24, 0),
            Player("Marques Bolden", "3", "C", "6-10", "250", "4/17/1998", 25, 2),
            Player("Miles Bridges", "0", "PF", "6-7", "225", "3/21/1998", 25, 4),
            Player("Seth Curry", "30", "SG", "6-1", "185", "8/23/1990", 33, 9),
            Player("Tre Mann", "23", "PG", "6-3", "178", "2/3/2001", 23, 2),
            Player("Cody Martin", "11", "SF", "6-6", "205", "9/28/1995", 28, 4),
            Player("Bryce McGowens", "7", "SF", "6-6", "175", "11/8/2002", 21, 1),
            Player("Vasilije Micic", "22", "PG", "6-3", "203", "1/13/1994", 30, 0),
            Player("Brandon Miller", "24", "SG", "6-7", "200", "11/22/2002", 21, 0),
            Player("Aleksej Pokusevski", "17", "PF", "7-0", "190", "12/26/2001", 22, 3),
            Player("Nick Richards", "4", "C", "7-0", "245", "11/29/1997", 26, 3),
            Player("Nick Smith Jr.", "8", "PG", "6-2", "185", "4/18/2004", 19, 0),
            Player("JT Thor", "21", "PF", "6-9", "203", "8/26/2002", 21, 2),
            Player("Grant Williams", "2", "PF", "6-6", "236", "11/30/1998", 25, 4),
            Player("Mark Williams", "5", "C", "7-0", "240", "12/16/2001", 22, 1)
        )
        val heatR = listOf(
            Player("Bam Adebayo", "13", "C", "6-9", "255", "7/18/1997", 26, 6),
            Player("Thomas Bryant", "31", "C", "6-10", "248", "7/31/1997", 26, 6),
            Player("Jimmy Butler", "22", "SF", "6-7", "230", "9/14/1989", 34, 12),
            Player("Jamal Cain", "8", "SF", "6-6", "191", "3/20/1999", 24, 1),
            Player("Tyler Herro", "14", "PG", "6-5", "195", "1/20/2000", 24, 4),
            Player("Haywood Highsmith", "24", "SF", "6-5", "220", "12/9/1996", 27, 3),
            Player("Jaime Jaquez Jr.", "11", "SF", "6-6", "226", "2/18/2001", 23, 0),
            Player("Nikola Jovic", "5", "PF", "6-10", "205", "6/9/2003", 20, 1),
            Player("Kevin Love", "42", "PF", "6-8", "251", "9/7/1988", 35, 15),
            Player("Caleb Martin", "16", "SF", "6-5", "205", "9/28/1995", 28, 4),
            Player("Patty Mills", "88", "PG", "6-2", "180", "8/11/1988", 35, 14),
            Player("Josh Richardson", "0", "SG", "6-5", "200", "9/15/1993", 30, 8),
            Player("Duncan Robinson", "55", "SG", "6-7", "215", "4/22/1994", 29, 5),
            Player("Orlando Robinson", "25", "C", "6-10", "235", "7/10/2000", 23, 1),
            Player("Terry Rozier", "2", "SG", "6-1", "190", "3/17/1994", 29, 8),
            Player("Cole Swider", "21", "PF", "6-8", "220", "5/8/1999", 24, 1),
            Player("Alondes Williams", "15", "SG", "6-4", "210", "6/19/1999", 24, 1),
            Player("Delon Wright", "4", "SG", "6-5", "185", "4/26/1992", 31, 8)
        )
        val magicR = listOf(
            Player("Cole Anthony", "50", "PG", "6-2", "185", "5/15/2000", 23, 3),
            Player("Paolo Banchero", "5", "PF", "6-10", "250", "11/12/2002", 21, 1),
            Player("Goga Bitadze", "35", "C", "6-10", "250", "7/20/1999", 24, 4),
            Player("Anthony Black", "0", "PG", "6-7", "200", "1/20/2004", 20, 0),
            Player("Wendell Carter Jr.", "34", "C", "6-10", "270", "4/16/1999", 24, 5),
            Player("Markelle Fultz", "20", "PG", "6-4", "209", "5/29/1998", 25, 6),
            Player("Gary Harris", "14", "SG", "6-4", "210", "9/14/1994", 29, 9),
            Player("Kevon Harris", "8", "SG", "6-5", "216", "6/24/1997", 26, 1),
            Player("Caleb Houstan", "2", "SF", "6-8", "205", "1/9/2003", 21, 1),
            Player("Jett Howard", "13", "SG", "6-6", "215", "9/14/2003", 20, 0),
            Player("Joe Ingles", "7", "SG", "6-9", "220", "10/2/1987", 36, 9),
            Player("Jonathan Isaac", "1", "PF", "6-10", "230", "10/3/1997", 26, 4),
            Player("Chuma Okeke", "3", "SG", "6-7", "229", "8/18/1998", 25, 3),
            Player("Trevelin Queen", "12", "SG", "6-5", "190", "2/25/1997", 27, 2),
            Player("Admiral Schofield", "25", "SF", "6-5", "240", "3/30/1997", 26, 3),
            Player("Jalen Suggs", "4", "SG", "6-5", "205", "6/3/2001", 22, 2),
            Player("Franz Wagner", "22", "PF", "6-10", "220", "8/27/2001", 22, 2),
            Player("Moe Wagner", "21", "C", "6-11", "245", "4/26/1997", 26, 5)
        )
        val wizzardsR = listOf(
            Player("Deni Avdija", "8", "SF", "6-9", "210", "1/3/2001", 23, 3),
            Player("Marvin Bagley III", "35", "C", "6-10", "235", "3/14/1999", 24, 5),
            Player("Patrick Baldwin Jr.", "7", "SF", "6-9", "220", "11/18/2002", 21, 1),
            Player("Jules Bernard", "14", "SG", "6-6", "205", "1/21/2000", 24, 0),
            Player("Jared Butler", "4", "PG", "6-3", "193", "8/25/2000", 23, 2),
            Player("Justin Champagnie", "9", "SF", "6-6", "206", "6/29/2001", 22, 2),
            Player("Bilal Coulibaly", "0", "SF", "6-8", "195", "7/26/2004", 19, 0),
            Player("Johnny Davis", "1", "SG", "6-4", "195", "2/27/2002", 22, 1),
            Player("Anthony Gill", "16", "PF", "6-8", "230", "10/17/1992", 31, 3),
            Player("R.J. Hampton", "15", "PG", "6-4", "175", "2/7/2001", 23, 3),
            Player("Richaun Holmes", "22", "C", "6-9", "235", "10/15/1993", 30, 8),
            Player("Tyus Jones", "5", "PG", "6-1", "196", "5/10/1996", 27, 8),
            Player("Corey Kispert", "24", "SG", "6-6", "224", "3/3/1999", 25, 2),
            Player("Kyle Kuzma", "33", "PF", "6-9", "221", "7/24/1995", 28, 6),
            Player("Isaiah Livers", "12", "SF", "6-6", "232", "7/28/1998", 25, 2),
            Player("Eugene Omoruyi", "97", "SF", "6-6", "235", "2/14/1997", 27, 2),
            Player("Jordan Poole", "13", "SG", "6-4", "194", "6/19/1999", 24, 4),
            Player("Landry Shamet", "20", "SG", "6-4", "190", "3/13/1997", 27, 5)
        )
        val rocketsR = listOf(
            Player("Steven Adams", "12", "C", "6-11", "265", "7/20/1993", 30, 10),
            Player("Dillon Brooks", "9", "SF", "6-6", "225", "1/22/1996", 28, 6),
            Player("Reggie Bullock", "25", "SG", "6-6", "205", "3/16/1991", 32, 10),
            Player("Tari Eason", "17", "PF", "6-8", "215", "5/10/2001", 22, 1),
            Player("Jalen Green", "4", "SG", "6-4", "186", "2/9/2002", 22, 2),
            Player("Jeff Green", "32", "PF", "6-8", "235", "8/28/1986", 37, 15),
            Player("Nate Hinton", "14", "SG", "6-5", "210", "6/8/1999", 24, 2),
            Player("Aaron Holiday", "0", "PG", "6-0", "185", "9/30/1996", 27, 5),
            Player("Jock Landale", "2", "C", "6-11", "255", "10/25/1995", 28, 2),
            Player("Boban Marjanovic", "51", "C", "7-4", "290", "8/15/1988", 35, 8),
            Player("Jermaine Samuels", "00", "SF", "6-6", "230", "11/13/1998", 25, 0),
            Player("Alperen Sengun", "28", "C", "6-11", "243", "7/25/2002", 21, 2),
            Player("Jabari Smith", "10", "PF", "6-11", "220", "5/13/2003", 20, 1),
            Player("Jae'Sean Tate", "8", "SF", "6-4", "230", "10/28/1995", 28, 3),
            Player("Amen Thompson", "1", "PG", "6-7", "199", "1/30/2003", 21, 0),
            Player("Fred VanVleet", "5", "PG", "6-0", "197", "2/25/1994", 30, 7),
            Player("Cam Whitmore", "7", "SG", "6-7", "230", "7/8/2004", 19, 0),
            Player("Nate Williams", "19", "SG", "6-5", "205", "2/12/1999", 25, 1)
        )
        val grizzliesR = listOf(
            Player("Santi Aldama", "7", "PF", "7-0", "215", "1/10/2001", 23, 2),
            Player("Desmond Bane", "22", "SG", "6-5", "215", "6/25/1998", 25, 3),
            Player("Brandon Clarke", "15", "C", "6-8", "215", "9/19/1996", 27, 4),
            Player("Wenyen Gabriel", "—", "PF", "6-9", "205", "3/26/1997", 26, 4),
            Player("Jordan Goodwin", "4", "SG", "6-4", "200", "10/23/1998", 25, 2),
            Player("Gregory Jackson", "45", "PF", "6-9", "210", "12/17/2004", 19, 0),
            Player("Jaren Jackson Jr.", "13", "PF", "6-10", "242", "9/15/1999", 24, 5),
            Player("DeJon Jarreau", "—", "PG", "6-5", "185", "1/23/1998", 26, 1),
            Player("Trey Jemison", "55", "C", "6-10", "260", "11/28/1999", 24, 0),
            Player("Luke Kennard", "10", "SG", "6-5", "206", "6/24/1996", 27, 6),
            Player("John Konchar", "46", "SG", "6-5", "210", "3/22/1996", 27, 4),
            Player("Jake LaRavia", "3", "SF", "6-7", "235", "11/3/2001", 22, 1),
            Player("Ja Morant", "12", "PG", "6-2", "174", "8/10/1999", 24, 4),
            Player("Scotty Pippen Jr.", "1", "PG", "6-1", "170", "11/10/2000", 23, 1),
            Player("Derrick Rose", "23", "PG", "6-3", "200", "10/4/1988", 35, 14),
            Player("Marcus Smart", "36", "PG", "6-3", "220", "3/6/1994", 30, 9),
            Player("Lamar Stevens", "24", "SF", "6-7", "230", "7/9/1997", 26, 3),
            Player("Yuta Watanabe", "18", "SF", "6-9", "215", "10/13/1994", 29, 5),
            Player("Ziaire Williams", "8", "SF", "6-9", "185", "9/12/2001", 22, 2),
            Player("Vince Williams Jr.", "5", "SF", "6-4", "205", "8/30/2000", 23, 1)
        )
        val pelicansR = listOf(
            Player("Jose Alvarado", "15", "PG", "6-0", "179", "4/12/1998", 25, 2),
            Player("Izaiah Brockington", "21", "SG", "6-4", "200", "7/12/1999", 24, 0),
            Player("Jalen Crutcher", "9", "PG", "6-2", "175", "7/18/1999", 24, 0),
            Player("Dyson Daniels", "11", "SG", "6-7", "199", "3/17/2003", 20, 1),
            Player("Jordan Hawkins", "24", "SG", "6-5", "190", "4/29/2002", 21, 0),
            Player("Malcolm Hill", "33", "SF", "6-6", "220", "10/26/1995", 28, 2),
            Player("Brandon Ingram", "14", "SF", "6-8", "190", "9/2/1997", 26, 7),
            Player("Herbert Jones", "5", "SG", "6-7", "206", "10/6/1998", 25, 2),
            Player("E.J. Liddell", "32", "SF", "6-6", "240", "12/18/2000", 23, 0),
            Player("Naji Marshall", "8", "SF", "6-6", "220", "1/24/1998", 26, 3),
            Player("CJ McCollum", "3", "PG", "6-3", "190", "9/19/1991", 32, 10),
            Player("Trey Murphy III", "25", "SF", "6-8", "206", "6/18/2000", 23, 2),
            Player("Larry Nance Jr.", "22", "PF", "6-8", "245", "1/1/1993", 31, 8),
            Player("Jeremiah Robinson-Earl", "50", "PF", "6-8", "242", "11/3/2000", 23, 2),
            Player("Matt Ryan", "37", "SF", "6-6", "215", "4/17/1997", 26, 2),
            Player("Dereon Seabron", "0", "SG", "6-5", "180", "5/26/2000", 23, 1),
            Player("Jonas Valanciunas", "17", "C", "6-11", "265", "5/6/1992", 31, 11),
            Player("Zion Williamson", "1", "PF", "6-6", "284", "7/6/2000", 23, 3),
            Player("Cody Zeller", "40", "C", "6-11", "240", "10/5/1992", 31, 10)
        )
        val spursR = listOf(
            Player("Dom Barlow", "26", "PF", "6-9", "215", "5/26/2003", 20, 1),
            Player("Charles Bassey", "28", "C", "6-10", "230", "10/28/2000", 23, 2),
            Player("Jamaree Bouyea", "—", "PG", "6-2", "180", "6/27/1999", 24, 1),
            Player("Malaki Branham", "22", "SG", "6-4", "180", "5/12/2003", 20, 1),
            Player("Julian Champagnie", "30", "SF", "6-7", "217", "6/29/2001", 22, 1),
            Player("Sidy Cissoko", "25", "SF", "6-5", "224", "4/2/2004", 19, 0),
            Player("Zach Collins", "23", "C", "6-11", "250", "11/19/1997", 26, 5),
            Player("David Duke Jr.", "7", "PG", "6-4", "204", "10/13/1999", 24, 2),
            Player("Devonte' Graham", "4", "PG", "6-1", "195", "2/22/1995", 29, 5),
            Player("RaiQuan Gray", "41", "PF", "6-7", "260", "7/7/1999", 24, 1),
            Player("Keldon Johnson", "3", "SF", "6-5", "220", "10/11/1999", 24, 4),
            Player("Tre Jones", "33", "PG", "6-1", "185", "1/8/2000", 24, 3),
            Player("Sandro Mamukelashvili", "54", "PF", "6-9", "240", "5/23/1999", 24, 2),
            Player("Cedi Osman", "16", "SF", "6-7", "230", "4/8/1995", 28, 6),
            Player("Jeremy Sochan", "10", "SF", "6-8", "230", "5/20/2003", 20, 1),
            Player("Devin Vassell", "24", "SG", "6-5", "200", "8/23/2000", 23, 3),
            Player("Victor Wembanyama", "1", "C", "7-4", "210", "1/4/2004", 20, 0),
            Player("Blake Wesley", "14", "SG", "6-3", "185", "3/16/2003", 20, 1)
        )
        val blazzersR = listOf(
            Player("Deandre Ayton", "2", "C", "7-0", "250", "7/23/1998", 25, 5),
            Player("Ibou Badji", "41", "C", "7-2", "230", "10/13/2002", 21, 0),
            Player("Dalano Banton", "5", "PG", "6-8", "204", "11/7/1999", 24, 2),
            Player("Malcolm Brogdon", "11", "PG", "6-4", "229", "12/11/1992", 31, 7),
            Player("Moses Brown", "10", "C", "7-2", "245", "10/13/1999", 24, 4),
            Player("Toumani Camara", "33", "SF", "6-7", "220", "5/8/2000", 23, 0),
            Player("Jerami Grant", "9", "PF", "6-7", "210", "3/12/1994", 30, 9),
            Player("Ashton Hagans", "22", "PG", "6-3", "190", "7/8/1999", 24, 1),
            Player("Scoot Henderson", "00", "PG", "6-3", "195", "2/3/2004", 20, 0),
            Player("Justin Minaya", "24", "SF", "6-5", "210", "3/26/1999", 24, 1),
            Player("Kris Murray", "8", "PF", "6-8", "220", "8/19/2000", 23, 0),
            Player("Duop Reath", "26", "C", "6-9", "245", "6/26/1996", 27, 0),
            Player("Rayan Rupert", "72", "SG", "6-6", "185", "5/31/2004", 19, 0),
            Player("Shaedon Sharpe", "17", "SG", "6-5", "200", "5/30/2003", 20, 1),
            Player("Anfernee Simons", "1", "SG", "6-3", "181", "6/8/1999", 24, 5),
            Player("Matisse Thybulle", "4", "SF", "6-5", "201", "3/4/1997", 27, 4),
            Player("Jabari Walker", "34", "PF", "6-7", "200", "7/30/2002", 21, 1),
            Player("Robert Williams III", "35", "C", "6-9", "237", "10/17/1997", 26, 5)
        )





        val listaEquipos = ArrayList<FranNBA>()

        val atlanta = FranNBA(R.drawable.atlanta,"Atlanta","Hawks", 0,"este","#cf0429", roster = atlantaR)
        val dallas = FranNBA(R.drawable.dallas,"Dallas","Mavericks",1, "oeste","#0079bf", roster = dallasR)
        val boston = FranNBA(R.drawable.boston,"Boston","Celtics",17, "este" ,"#007f47", roster = bostonR)
        val denver = FranNBA(R.drawable.denver,"Denver","Nuggets", 1,"oeste","#14305c", roster = nuggetsR)
        val brooklyn = FranNBA(R.drawable.brooklyn,"Brooklyn","Nets", 0,"este","#7b7b7b", roster = brooklynR)
        val golden = FranNBA(R.drawable.golden_state,"Golden State","Warriors",7,"oeste","#f4d024", roster = warriorsR)
        val charlotte = FranNBA(R.drawable.charlotte,"Charlotte","Hornets",0, "este","#0088a3", roster = hornetsR)
        val houston = FranNBA(R.drawable.houston_rockets,"Houston","Rockets",2, "oeste","#d81f30", roster = rocketsR)
        val chicago = FranNBA(R.drawable.chicago,"Chicago","Bulls",6, "este","#bf041f", roster = chicacgoR)
        val clippers = FranNBA(R.drawable.clippers,"LA","Clippers",0, "oeste","#1c4085", roster = clippersR)
        val cleveland = FranNBA(R.drawable.cleveland,"Cleveland","Cavaliers",1, "este","#6f243a", roster = clevelandR)
        val lakers = FranNBA(R.drawable.lakers,"Los Angeles","Lakers",17, "oeste","#30016e", roster = lakersR)
        val detroit = FranNBA(R.drawable.pistons,"Detroit","Pistons", 3,"este","#f8f8f8", roster = pistonsR)
        val memphis = FranNBA(R.drawable.memphis,"Memphis","Grizzlies",0, "oeste","#6ca5de", roster = grizzliesR)
        val indiana = FranNBA(R.drawable.indiana_pacers_seeklogo,"Indiana","Pacers",0, "este","#002c5f", roster = pacersR)
        val minesota = FranNBA(R.drawable.minnesota,"Minnesota","Timberwolves",0, "oeste","#024d82", roster = timberwolvesR)
        val miami = FranNBA(R.drawable.miami,"Miami","Heat",3,"este","#94012d", roster = heatR)
        val newOrleans = FranNBA(R.drawable.new_orleans,"New Orleans","Pelicans",0, "oeste","#562e5a", roster = pelicansR)
        val milwaukee = FranNBA(R.drawable.milwakeu,"Milwaukee","Bucks",2, "este","#004519", roster = bucksR)
        val oklahoma = FranNBA(R.drawable.okc,"Oklahoma City","Thunder",0, "oeste","#012d60", roster = thunderR)
        val newYork = FranNBA(R.drawable.knicks,"New York","Knicks",2, "este","#12479c", roster = newyorkR)
        val phoenix = FranNBA(R.drawable.phoenix,"Phoenix","Suns",0, "oeste","#443877", roster = sunsR)
        val orlando = FranNBA(R.drawable.orlando,"Orlando","Magic",0, "este","#0372ba", roster = magicR)
        val portland = FranNBA(R.drawable.portland,"Portland","Trail Blazzers",0, "oeste","#bf0e27", roster = blazzersR)
        val phili = FranNBA(R.drawable.phili,"Philadelphia","76ers",2, "este","#e70b2d", roster = sixersR)
        val sacramento = FranNBA(R.drawable.sacramento,"Sacramento","Kings",0, "oeste","#341c74", roster = kingsR)
        val toronto = FranNBA(R.drawable.toronto,"Toronto","Raptors",1, "este","#eb3d3c", roster = raptorsR)
        val sanAntonio = FranNBA(R.drawable.san_antonio,"San Antonio","Spurs",5, "oeste","#bbc3ca", roster = spursR)
        val washington = FranNBA(R.drawable.wizards,"Washington","Wizards",1, "este","#f8f8f8", roster = wizzardsR)
        val utah = FranNBA(R.drawable.utah,"Utah","Jazz",0, "oeste","#66578c", roster = utahR)

        listaEquipos.add(dallas)
        listaEquipos.add(atlanta)
        listaEquipos.add(denver)
        listaEquipos.add(boston)
        listaEquipos.add(golden)
        listaEquipos.add(brooklyn)
        listaEquipos.add(houston)
        listaEquipos.add(charlotte)
        listaEquipos.add(clippers)
        listaEquipos.add(chicago)
        listaEquipos.add(lakers)
        listaEquipos.add(cleveland)
        listaEquipos.add(memphis)
        listaEquipos.add(detroit)
        listaEquipos.add(minesota)
        listaEquipos.add(indiana)
        listaEquipos.add(newOrleans)
        listaEquipos.add(miami)
        listaEquipos.add(oklahoma)
        listaEquipos.add(milwaukee)
        listaEquipos.add(phoenix)
        listaEquipos.add(newYork)
        listaEquipos.add(portland)
        listaEquipos.add(orlando)
        listaEquipos.add(sacramento)
        listaEquipos.add(phili)
        listaEquipos.add(sanAntonio)
        listaEquipos.add(toronto)
        listaEquipos.add(utah)
        listaEquipos.add(washington)


        val layoutManager = GridLayoutManager(requireContext(),2)
        equiposAdapter = EquiposAdapter(listaEquipos)

        binding.rvEquipos.layoutManager = layoutManager
        binding.rvEquipos.adapter = equiposAdapter as EquiposAdapter


    }
    private fun navigateToRosterFragment(nombreEquipo: String) {
        val intent = Intent(requireContext(), RosterFragment::class.java).apply {
            putExtra("nombreEquipo", nombreEquipo)
        }
        startActivity(intent)
    }
    private fun onEquipoSelected(nombreEquipo: String) {
        navigateToRosterFragment(nombreEquipo)
    }
}


