package com.rahmatdev.moovie.utils

import com.rahmatdev.moovie.data.MovieEntity
import com.rahmatdev.moovie.data.TvShowEntity

object DataDummy {

    fun generateDummyMovies(): List<MovieEntity> {
        val movies = ArrayList<MovieEntity>()

        movies.add(MovieEntity(299536,
            "Avengers: Infinity War",
            "As the Avengers and their allies have continued to protect the world from threats too large for any one hero to handle, a new danger has emerged from the cosmic shadows: Thanos. A despot of intergalactic infamy, his goal is to collect all six Infinity Stones, artifacts of unimaginable power, and use them to inflict his twisted will on all of reality. Everything the Avengers have fought for has led up to this moment - the fate of Earth and existence itself has never been more uncertain.",
            "2018-04-25",
        8.3,
            "Adventure, Action, Science Fiction",
            "2h 29m",
            "https://image.tmdb.org/t/p/w200/7WsyChQLEftFiDOVTGkv3hFpyyt.jpg"))
        movies.add(MovieEntity(297802,
            "Aquaman",
            "Once home to the most advanced civilization on Earth, Atlantis is now an underwater kingdom ruled by the power-hungry King Orm. With a vast army at his disposal, Orm plans to conquer the remaining oceanic people and then the surface world. Standing in his way is Arthur Curry, Orm's half-human, half-Atlantean brother and true heir to the throne.",
            "2018-12-07",
            6.9,
            "Action, Adventure, Fantasy",
            "2h 23m",
            "https://image.tmdb.org/t/p/w200/xLPffWMhMj1l50ND3KchMjYoKmE.jpg"))
        movies.add(MovieEntity(480530,
            "Creed II",
            "Between personal obligations and training for his next big fight against an opponent with ties to his family's past, Adonis Creed is up against the challenge of his life.",
            "2018-11-21",
            6.9,
            "Drama",
            "2h 10m",
            "https://image.tmdb.org/t/p/w200/v3QyboWRoA4O9RbcsqH8tJMe8EB.jpg"))
        movies.add(MovieEntity(450465,
            "Glass",
            "In a series of escalating encounters, former security guard David Dunn uses his supernatural abilities to track Kevin Wendell Crumb, a disturbed man who has twenty-four personalities. Meanwhile, the shadowy presence of Elijah Price emerges as an orchestrator who holds secrets critical to both men.",
            "2019-01-16",
            6.7,
            "Thriller, Drama, Science Fiction",
            "2h 9m",
            "https://image.tmdb.org/t/p/w200/svIDTNUoajS8dLEo7EosxvyAsgJ.jpg"))
        movies.add(MovieEntity(166428,
            "How to Train Your Dragon: The Hidden World",
            "As Hiccup fulfills his dream of creating a peaceful dragon utopia, Toothless’ discovery of an untamed, elusive mate draws the Night Fury away. When danger mounts at home and Hiccup’s reign as village chief is tested, both dragon and rider must make impossible decisions to save their kind.",
            "2019-01-03",
            7.8,
            "Animation, Family, Adventure",
            "1h 44m",
            "https://image.tmdb.org/t/p/w200/xvx4Yhf0DVH8G4LzNISpMfFBDy2.jpg"))
        movies.add(MovieEntity(82690,
            "Wreck-It Ralph",
            "Wreck-It Ralph is the 9-foot-tall, 643-pound villain of an arcade video game named Fix-It Felix Jr., in which the game's titular hero fixes buildings that Ralph destroys. Wanting to prove he can be a good guy and not just a villain, Ralph escapes his game and lands in Hero's Duty, a first-person shooter where he helps the game's hero battle against alien invaders. He later enters Sugar Rush, a kart racing game set on tracks made of candies, cookies and other sweets. There, Ralph meets Vanellope von Schweetz who has learned that her game is faced with a dire threat that could affect the entire arcade, and one that Ralph may have inadvertently started.",
            "2012-01-01",
            7.3,
            "Family, Animation, Comedy, Adventure",
            "1h 41m",
            "https://image.tmdb.org/t/p/w200/zWoIgZ7mgmPkaZjG0102BSKFIqQ.jpg"))
        movies.add(MovieEntity(324857,
            "Spider-Man: Into the Spider-Verse",
            "Miles Morales is juggling his life between being a high school student and being a spider-man. When Wilson \"Kingpin\" Fisk uses a super collider, others from across the Spider-Verse are transported to this dimension.",
            "2018-12-06",
            8.4,
            "Action, Adventure, Animation, Science Fiction, Comedy",
            "1h 57m",
            "https://image.tmdb.org/t/p/w200/iiZZdoQBEYBv6id8su7ImL0oCbD.jpg"))
        movies.add(MovieEntity(375588,
            "Robin Hood",
            "A war-hardened Crusader and his Moorish commander mount an audacious revolt against the corrupt English crown.",
            "2018-11-21",
            5.9,
            "Adventure, Action, Thriller",
            "1h 56m",
            "https://image.tmdb.org/t/p/w200/AiRfixFcfTkNbn2A73qVJPlpkUo.jpg"))
        movies.add(MovieEntity(505954,
            "T-34",
            "In 1944, a courageous group of Russian soldiers managed to escape from German captivity in a half-destroyed legendary T-34 tank. Those were the times of unforgettable bravery, fierce fighting, unbreakable love, and legendary miracles.",
            "2018-12-27",
            6.9,
            "War, Action, Drama, History",
            "2h 19m",
            "https://image.tmdb.org/t/p/w200/jqBIHiSglRfNxjh1zodHLa9E7zW.jpg"))
        movies.add(MovieEntity(438799,
            "Overlord",
            "France, June 1944. On the eve of D-Day, some American paratroopers fall behind enemy lines after their aircraft crashes while on a mission to destroy a radio tower in a small village near the beaches of Normandy. After reaching their target, the surviving paratroopers realise that, in addition to fighting the Nazi troops that patrol the village, they also must fight against something else.",
            "2018-11-01",
            6.7,
            "Horror, War, Science Fiction",
            "1h 50m",
            "https://image.tmdb.org/t/p/w200/l76Rgp32z2UxjULApxGXAPpYdAP.jpg"))

        return movies
    }

    fun generateDummyTvShows(): List<TvShowEntity> {
        val tvShows = ArrayList<TvShowEntity>()

        tvShows.add(TvShowEntity(1412,
            "Arrow",
            "Spoiled billionaire playboy Oliver Queen is missing and presumed dead when his yacht is lost at sea. He returns five years later a changed man, determined to clean up the city as a hooded vigilante armed with a bow.",
            "2012",
            6.6,
            "Crime, Drama, Mystery, Action & Adventure",
            24,
            "https://image.tmdb.org/t/p/w200/gKG5QGz5Ngf8fgWpBsWtlg5L2SF.jpg"))
        tvShows.add(TvShowEntity(12609,
            "Dragon Ball",
            "Long ago in the mountains, a fighting master known as Gohan discovered a strange boy whom he named Goku. Gohan raised him and trained Goku in martial arts until he died. The young and very strong boy was on his own, but easily managed. Then one day, Goku met a teenage girl named Bulma, whose search for the mystical Dragon Balls brought her to Goku's home. Together, they set off to find all seven and to grant her wish.",
            "1986",
            8.1,
            "Animation, Action & Adventure, Sci-Fi & Fantasy",
            153,
            "https://image.tmdb.org/t/p/w200/tZ0jXOeYBWPZ0OWzUhTlYvMF7YR.jpg"))
        tvShows.add(TvShowEntity(46261,
            "Fairy Tail",
            "Lucy is a 17-year-old girl, who wants to be a full-fledged mage. One day when visiting Harujion Town, she meets Natsu, a young man who gets sick easily by any type of transportation. But Natsu isn't just any ordinary kid, he's a member of one of the world's most infamous mage guilds: Fairy Tail.",
            "2009",
            7.8,
            "Action & Adventure, Animation, Comedy, Sci-Fi & Fantasy, Mystery",
            48,
            "https://image.tmdb.org/t/p/w200/jsYTctFnK8ewomnUgcwhmsTkOum.jpg"))
        tvShows.add(TvShowEntity(60735,
            "The Flash",
            "After a particle accelerator causes a freak storm, CSI Investigator Barry Allen is struck by lightning and falls into a coma. Months later he awakens with the power of super speed, granting him the ability to move through Central City like an unseen guardian angel. Though initially excited by his newfound powers, Barry is shocked to discover he is not the only \"meta-human\" who was created in the wake of the accelerator explosion -- and not everyone is using their new powers for good. Barry partners with S.T.A.R. Labs and dedicates his life to protect the innocent. For now, only a few close friends and associates know that Barry is literally the fastest man alive, but it won't be long before the world learns what Barry Allen has become...The Flash.",
            "2014",
            7.7,
            "Drama, Sci-Fi & Fantasy",
            23,
            "https://image.tmdb.org/t/p/w200/lJA2RCMfsWoskqlQhXPSLFQGXEJ.jpg"))
        tvShows.add(TvShowEntity(60708,
            "Gotham",
            "Everyone knows the name Commissioner Gordon. He is one of the crime world's greatest foes, a man whose reputation is synonymous with law and order. But what is known of Gordon's story and his rise from rookie detective to Police Commissioner? What did it take to navigate the multiple layers of corruption that secretly ruled Gotham City, the spawning ground of the world's most iconic villains? And what circumstances created them – the larger-than-life personas who would become Catwoman, The Penguin, The Riddler, Two-Face and The Joker?",
            "2014",
            7.5,
            "Drama, Crime, Sci-Fi & Fantasy",
            22,
            "https://image.tmdb.org/t/p/w200/4XddcRDtnNjYmLRMYpbrhFxsbuq.jpg"))
        tvShows.add(TvShowEntity(31910,
            "Naruto Shippūden",
            "Naruto Shippuuden is the continuation of the original animated TV series Naruto.The story revolves around an older and slightly more matured Uzumaki Naruto and his quest to save his friend Uchiha Sasuke from the grips of the snake-like Shinobi, Orochimaru. After 2 and a half years Naruto finally returns to his village of Konoha, and sets about putting his ambitions to work, though it will not be easy, as He has amassed a few (more dangerous) enemies, in the likes of the shinobi organization; Akatsuki.",
            "2007",
            8.6,
            "Animation, Action & Adventure, Sci-Fi & Fantasy",
            32,
            "https://image.tmdb.org/t/p/w200/zAYRe2bJxpWTVrwwmBc00VFkAf4.jpg"))
        tvShows.add(TvShowEntity(62688,
            "Supergirl",
            "Twenty-four-year-old Kara Zor-El, who was taken in by the Danvers family when she was 13 after being sent away from Krypton, must learn to embrace her powers after previously hiding them. The Danvers teach her to be careful with her powers, until she has to reveal them during an unexpected disaster, setting her on her journey of heroism.",
            "2015",
            7.3,
            "Drama, Sci-Fi & Fantasy, Action & Adventure",
            20,
            "https://image.tmdb.org/t/p/w200/zsaiq8ZclPuneuN7loLEbsh1ANJ.jpg"))
        tvShows.add(TvShowEntity(456,
            "The Simpsons",
            "Set in Springfield, the average American town, the show focuses on the antics and everyday adventures of the Simpson family; Homer, Marge, Bart, Lisa and Maggie, as well as a virtual cast of thousands. Since the beginning, the series has been a pop culture icon, attracting hundreds of celebrities to guest star. The show has also made name for itself in its fearless satirical take on politics, media and American life in general.",
            "1989",
            7.8,
            "Family, Animation, Comedy",
            13,
            "https://image.tmdb.org/t/p/w200/2IWouZK4gkgHhJa3oyYuSWfSqbG.jpg"))
        tvShows.add(TvShowEntity(75006,
            "The Umbrella Academy",
            "A dysfunctional family of superheroes comes together to solve the mystery of their father's death, the threat of the apocalypse and more.",
            "2019",
            8.7,
            "Action & Adventure, Sci-Fi & Fantasy, Drama",
            10,
            "https://image.tmdb.org/t/p/w200/scZlQQYnDVlnpxFTxaIv2g0BWnL.jpg"))
        tvShows.add(TvShowEntity(1402,
            "The Walking Dead",
            "Sheriff's deputy Rick Grimes awakens from a coma to find a post-apocalyptic world dominated by flesh-eating zombies. He sets out to find his family and encounters many other survivors along the way.",
            "2010",
            8.1,
            "Action & Adventure, Drama, Sci-Fi & Fantasy",
            6,
            "https://image.tmdb.org/t/p/w200/rqeYMLryjcawh2JeRpCVUDXYM5b.jpg"))

        return tvShows
    }
}