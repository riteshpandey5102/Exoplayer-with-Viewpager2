package com.example.exoplayerwithviewpager2

class DummyData {
    companion object {
        val videoList = listOf(
            "https://firebasestorage.googleapis.com/v0/b/video-app-398fb.appspot.com/o/video%20(1).mp4?alt=media&token=5625ebe7-99e6-4c42-930d-781da84e4feb",
            "https://firebasestorage.googleapis.com/v0/b/video-app-398fb.appspot.com/o/video%20(3).mp4?alt=media&token=abfccaf0-2426-4a0a-8052-259de1724fe8",
            "https://firebasestorage.googleapis.com/v0/b/video-app-398fb.appspot.com/o/video%20(2).mp4?alt=media&token=299535bc-5777-4db1-8b97-e476be8e620c",
            "https://firebasestorage.googleapis.com/v0/b/video-app-398fb.appspot.com/o/video%20(4).mp4?alt=media&token=f216a022-7636-4de8-b69a-d45e3b4802f4",
            "https://firebasestorage.googleapis.com/v0/b/video-app-398fb.appspot.com/o/video%20(5).mp4?alt=media&token=5f6fa5a5-79bc-4e19-a6e2-1242c86579cf",
            "https://firebasestorage.googleapis.com/v0/b/video-app-398fb.appspot.com/o/video%20(6).mp4?alt=media&token=1c94e4e3-1935-461d-8bf7-f44c6aa43545",
            "https://firebasestorage.googleapis.com/v0/b/video-app-398fb.appspot.com/o/video%20(7).mp4?alt=media&token=d8109124-c2eb-43dd-8a89-e73d40f9c09e",
            "https://firebasestorage.googleapis.com/v0/b/video-app-398fb.appspot.com/o/video%20(8).mp4?alt=media&token=2c1f8531-ba62-4145-9fe5-fc6b67b20bf7",
            "https://firebasestorage.googleapis.com/v0/b/video-app-398fb.appspot.com/o/video%20(9).mp4?alt=media&token=e8ba654b-741e-45b4-a778-e91fbc160b96",
            "https://firebasestorage.googleapis.com/v0/b/video-app-398fb.appspot.com/o/video%20(10).mp4?alt=media&token=618479bd-99a9-493d-83c9-ab6a658e83c9",
            "https://firebasestorage.googleapis.com/v0/b/video-app-398fb.appspot.com/o/video%20(11).mp4?alt=media&token=02926f1d-a9ec-434e-9532-531e63ec6aef",
            "https://firebasestorage.googleapis.com/v0/b/video-app-398fb.appspot.com/o/video%20(12).mp4?alt=media&token=845f0f1c-4267-4701-a2cd-a44f6aff927c",
            "https://firebasestorage.googleapis.com/v0/b/video-app-398fb.appspot.com/o/video%20(13).mp4?alt=media&token=a6d25d13-2c03-4796-8c02-702466cb1454",
            "https://firebasestorage.googleapis.com/v0/b/video-app-398fb.appspot.com/o/video%20(14).mp4?alt=media&token=0a61092e-d2b9-4b82-a8c1-62bb2ba63e6d",
            "https://firebasestorage.googleapis.com/v0/b/video-app-398fb.appspot.com/o/video%20(15).mp4?alt=media&token=d4b3cfd6-3de6-474d-81e6-e889dc22785a",
            "https://firebasestorage.googleapis.com/v0/b/video-app-398fb.appspot.com/o/video%20(16).mp4?alt=media&token=3c044639-25d4-48b5-b2e7-64db23c547ec",
            "https://firebasestorage.googleapis.com/v0/b/video-app-398fb.appspot.com/o/video%20(17).mp4?alt=media&token=87ece4be-f958-4bb4-bd7b-f74f9428219b",
            "https://firebasestorage.googleapis.com/v0/b/video-app-398fb.appspot.com/o/video%20(18).mp4?alt=media&token=6ee4743d-5a7c-4011-a72d-9ec8f348ae4c",
            "https://firebasestorage.googleapis.com/v0/b/video-app-398fb.appspot.com/o/video%20(19).mp4?alt=media&token=c050610b-9f39-44ab-9e28-a3cfd66b821d",
            "https://firebasestorage.googleapis.com/v0/b/video-app-398fb.appspot.com/o/video%20(20).mp4?alt=media&token=a060976e-11ea-4011-9a4d-c9237b768749",
            "https://firebasestorage.googleapis.com/v0/b/video-app-398fb.appspot.com/o/video%20(21).mp4?alt=media&token=37a83956-888b-475d-a1f8-ff053e1ffd67",
            "https://firebasestorage.googleapis.com/v0/b/video-app-398fb.appspot.com/o/video%20(22).mp4?alt=media&token=83c1df50-d855-4cb6-a74f-dff0f0b66bf5",
            "https://firebasestorage.googleapis.com/v0/b/video-app-398fb.appspot.com/o/video%20(23).mp4?alt=media&token=adf703a4-4fb4-47a0-97fe-be25a8a4cf3d",
            "https://firebasestorage.googleapis.com/v0/b/video-app-398fb.appspot.com/o/video%20(24).mp4?alt=media&token=9db82d39-f880-44c4-8c7a-392fd6fc2e85",
            "https://firebasestorage.googleapis.com/v0/b/video-app-398fb.appspot.com/o/video%20(25).mp4?alt=media&token=5ace1768-1980-4d55-aaf1-c882835672c6",
            "https://firebasestorage.googleapis.com/v0/b/video-app-398fb.appspot.com/o/video%20(26).mp4?alt=media&token=b14a4823-144f-4df2-bbea-840d3a0a8a0b",
            "https://firebasestorage.googleapis.com/v0/b/video-app-398fb.appspot.com/o/video%20(27).mp4?alt=media&token=63faf2f4-7bb3-4858-bfc9-82b9269c8012",
            "https://firebasestorage.googleapis.com/v0/b/video-app-398fb.appspot.com/o/video%20(28).mp4?alt=media&token=c5d1c86f-2c87-445d-831a-52cf3d664ce4",
            "https://firebasestorage.googleapis.com/v0/b/video-app-398fb.appspot.com/o/video%20(29).mp4?alt=media&token=6a3a9a4e-57db-4277-a084-f29e7a72322b",
            "https://firebasestorage.googleapis.com/v0/b/video-app-398fb.appspot.com/o/video%20(30).mp4?alt=media&token=15dd1b1c-f7f4-46f7-a41d-5f0a2834b765",
            "https://firebasestorage.googleapis.com/v0/b/video-app-398fb.appspot.com/o/video%20(31).mp4?alt=media&token=1c41dff0-7100-4915-95b3-25e14bfdb486",
            "https://firebasestorage.googleapis.com/v0/b/video-app-398fb.appspot.com/o/video%20(32).mp4?alt=media&token=48851765-6f8c-4210-b1b0-31baaef1f98d",
        )
    }
}