package com.example.mycity.data
import com.example.mycity.model.Place

object PlaceList {
    val places = listOf(
        Place(
            name = "かんざんじ温泉",
            description = "浜名湖畔にある温泉街。日帰り温泉施設や旅館もあり、癒しの時間を過ごせる。",
            type = "観光"
        ),
        Place(
            name = "浜名湖",
            description ="浜名湖は汽水湖で、釣り・カヤック・クルーズなど多彩なアクティビティが楽しめる自然豊かな観光地",
            type = "観光"
        ),
        Place(
            name = "中田島砂丘",
            description = "日本三大砂丘の一つ。遠州灘に面し、ウミガメの産卵地としても有名。夕焼けが特に綺麗。",
            type = "観光"
        ),
        Place(
            name = "はままつフラワーパーク",
            description = "季節の花々が咲き誇る植物園。桜やチューリップ、バラなどの名所としても人気。",
            type = "観光"
        ),
        Place(
            name = "うなぎ専門店 八百徳",
            description = "浜松名物「うな重」が味わえる老舗。創業100年以上の伝統の味",
            type = "グルメ"
        ),
        Place(
            name = "浜松餃子　石松",
            description = "もやしが添えられた円形盛り付けが特徴の浜松餃子の代表格。地元民にも観光客にも大人気。",
            type = "グルメ"
        ),
        Place(
            name = "炭焼きレストラン　さわやか",
            description = "静岡県民のソウルフード。ジューシーな「げんこつハンバーグ」は行列必至。",
            type = "グルメ"
        ),
        Place(
            "アクトシティ浜松",
            description = "音楽の街・浜松の象徴。オペラやクラシックコンサートが開催されるホールや展望ロビーあり。",
            type = "音楽"
        ),
        Place(
            name = "浜松市楽器博物館",
            description = "世界中の楽器を展示。試奏できるコーナーもあり、音楽好きにはたまらない施設。",
            type = "音楽"
        ),
        Place(
            name = "浜松市動物園",
            description = "コンパクトながら人気のある動物園。キリンやライオン、レッサーパンダなどが見られる。",
            type = "その他"
        ),
        Place(
            name = "はままつフルーツパーク　時之栖",
            description = "果物狩りやアスレチック、温泉施設もある家族向け大型レジャー施設。",
            type = "その他"
        )
    )
}