package com.mikhienkov.data.api.service

import com.mikhienkov.data.api.model.HotelProfile
import com.mikhienkov.domain.valueobjects.HotelCategory
import com.mikhienkov.domain.valueobjects.HotelFacility
import java.time.LocalDate
import java.util.UUID
import kotlin.random.Random


private val reviewAuthors = listOf(
    HotelProfile.Review.Author(
        name = "Анна Мосина",
        avatarUrl = "https://images.unsplash.com/photo-1580489944761-15a19d654956?ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D&auto=format&fit=crop&w=461&q=80"
    ),
    HotelProfile.Review.Author(
        name = "Андрей Попов",
        avatarUrl = "https://images.unsplash.com/photo-1543610892-0b1f7e6d8ac1?ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D&auto=format&fit=crop&w=387&q=80"
    ),
    HotelProfile.Review.Author(
        name = "Михаил Савельве",
        avatarUrl = "https://images.unsplash.com/photo-1566492031773-4f4e44671857?ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D&auto=format&fit=crop&w=387&q=80"
    ),
    HotelProfile.Review.Author(
        name = "Катерина Ланина",
        avatarUrl = "https://plus.unsplash.com/premium_photo-1677368597077-009727e906db?ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D&auto=format&fit=crop&w=387&q=80"
    ),
    HotelProfile.Review.Author(
        name = "Дарья Донцова",
        avatarUrl = "https://images.unsplash.com/photo-1558898479-33c0057a5d12?ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D&auto=format&fit=crop&w=1170&q=80"
    )
)

private val reviews = listOf(
    5 to "Действительно исключительный отдых. Персонал сделал все возможное, чтобы сделать наш визит незабываемым. Удобства были на высшем уровне.",
    4 to "Достойный отель с дружелюбным персоналом. Меню ресторана могло бы быть более разнообразным.",
    4 to "Прекрасные виды и расслабляющая атмосфера. Бассейн был самым ярким моментом.",
    5 to "Модно и удобно. Удобства в отеле отличные, особенно фитнес-центр.",
    5 to "Отличное соотношение цены и качества. Конференц-зал был хорошо оборудован для моих деловых нужд.",
    5 to "Невероятная атмосфера и внимательный персонал. Оснащение конференц-зала было на высшем уровне для нашего корпоративного мероприятия.",
    4 to "Изысканный отдых, в котором тщательно продумана каждая деталь. Кулинарные предложения ресторана порадовали.",
    3 to "Завышенная цена за впечатления. Персонал ресторана казался неорганизованным, а Wi-Fi почти не работал во время моего пребывания.",
    2 to "Ожидали большего от роскошного отеля. В фитнес-центре не было надлежащего обслуживания, а обслуживание номеров было медленным.",
    3 to "Разочаровывающее пребывание в целом. Вид был единственным ярким моментом; остальные удобства казались устаревшими.",
    3 to "Вводящие в заблуждение фотографии в Интернете. Отель казался устаревшим, а качество еды в ресторане не соответствовало ценам.",
    5 to "Центральное расположение и внимательный персонал. Современный дизайн и удобства отеля превзошли мои ожидания.",
    5 to "Идеально подходит для кратковременного пребывания в городе. Удобство наличия хорошо оборудованного фитнес-центра было несомненным плюсом.",
    4 to "Стильный и компактный, идеально подходит для индивидуальных путешественников. Круглосуточный доступ к Wi-Fi стал для меня спасением в работе.",
    5 to "Скрытая жемчужина на берегу реки. Безмятежная атмосфера отеля сделала мой отпуск по-настоящему незабываемым."
)


private fun randomDate(): LocalDate {
    val year = Random.nextInt(from = 2021, until = 2023)
    val month = Random.nextInt(from = 1, until = 7)
    val day = Random.nextInt(from = 1, until = 28)
    return LocalDate.of(year, month, day)
}

private fun randomReviews(): List<HotelProfile.Review> {
    val count = Random.nextInt(from = 1, until = 15)
    val result = mutableListOf<HotelProfile.Review>()
    repeat(count) {
        val review = reviews.random()
        result.add(
            HotelProfile.Review(
                author = reviewAuthors.random(),
                rating = review.first,
                text = review.second,
                created = randomDate()
            )
        )
    }
    return result
}


private val hotelNames = listOf(
    "Времена года",
    "Городской пульс",
    "Небесный лофт",
    "Метрополитен Отель",
    "Гостиница Тренд",
    "Столичные ночи",
    "Утренний Рассвет",
    "Белый Лебедь",
    "Тёплый Приют",
    "Лазурный Берег",
    "Ночной Сапфир",
    "Лагуна Блаженства",
    "Серебряный Дюны",
    "Вечерний Бриз",
    "Речной Пейзаж",
    "Гармония Природы",
    "Райский Уголокr",
    "Атмосфера Столицы",
    "Урбаника",
    "Лесной Уют",
    "Южные Ночи",
    "Тайная Лагуна"
)

private val hotelAddresses = listOf(
    HotelProfile.Location(longitude = "37.617635", latitude = "55.755814") to HotelProfile.Address(
        country = "Россия",
        city = "Москва",
        addressLine1 = "ул. Арбат, 1"
    ),
    HotelProfile.Location(longitude = "30.315868", latitude = "59.939095") to HotelProfile.Address(
        country = "Россия",
        city = "Санкт-Петербург",
        addressLine1 = "Невский проспект, 50"
    ),
    HotelProfile.Location(longitude = "37.558525", latitude = "55.752220") to HotelProfile.Address(
        country = "Россия",
        city = "Москва",
        addressLine1 = "ул. Тверская, 15"
    ),
    HotelProfile.Location(longitude = "49.122141", latitude = "55.782354") to HotelProfile.Address(
        country = "Россия",
        city = "Казань",
        addressLine1 = "ул. Баумана, 10"
    ),
    HotelProfile.Location(longitude = "39.701505", latitude = "47.226480") to HotelProfile.Address(
        country = "Россия",
        city = "Ростов-на-Дону",
        addressLine1 = "проспект Ворошиловский, 25"
    ),
    HotelProfile.Location(longitude = "56.238240", latitude = "58.010375") to HotelProfile.Address(
        country = "Россия",
        city = "Пермь",
        addressLine1 = "ул. Ленина, 12"
    ),
    HotelProfile.Location(longitude = "30.360909", latitude = "59.934280") to HotelProfile.Address(
        country = "Россия",
        city = "Санкт-Петербург",
        addressLine1 = "ул. Рубинштейна, 22"
    ),
    HotelProfile.Location(longitude = "40.396011", latitude = "56.142202") to HotelProfile.Address(
        country = "Россия",
        city = "Владимир",
        addressLine1 = "ул. Большая Московская, 15"
    ),
    HotelProfile.Location(longitude = "37.479946", latitude = "55.709580") to HotelProfile.Address(
        country = "Россия",
        city = "Москва",
        addressLine1 = "Ленинский проспект, 80"
    ),
    HotelProfile.Location(longitude = "44.616650", latitude = "48.707103") to HotelProfile.Address(
        country = "Россия",
        city = "Волгоград",
        addressLine1 = "проспект Ленина, 5"
    ),
    HotelProfile.Location(longitude = "39.720317", latitude = "43.587524") to HotelProfile.Address(
        country = "Россия",
        city = "Сочи",
        addressLine1 = "ул. Воровского, 3"
    ),
    HotelProfile.Location(longitude = "37.605598", latitude = "55.745287") to HotelProfile.Address(
        country = "Россия",
        city = "Москва",
        addressLine1 = "ул. Никольская, 25"
    ),
    HotelProfile.Location(longitude = "55.968814", latitude = "54.736897") to HotelProfile.Address(
        country = "Россия",
        city = "Уфа",
        addressLine1 = "проспект Октября, 10"
    ),
    HotelProfile.Location(longitude = "40.282450", latitude = "45.034134") to HotelProfile.Address(
        country = "Россия",
        city = "Краснодар",
        addressLine1 = "ул. Красная, 15"
    ),
    HotelProfile.Location(longitude = "37.651477", latitude = "55.755289") to HotelProfile.Address(
        country = "Россия",
        city = "Москва",
        addressLine1 = "ул. Покровка, 30"
    ),
    HotelProfile.Location(longitude = "39.006670", latitude = "45.037986") to HotelProfile.Address(
        country = "Россия",
        city = "Краснодар",
        addressLine1 = "ул. Северная, 25"
    ),
    HotelProfile.Location(longitude = "30.330556", latitude = "59.940092") to HotelProfile.Address(
        country = "Россия",
        city = "Санкт-Петербург",
        addressLine1 = "ул. Думская, 7"
    ),
    HotelProfile.Location(longitude = "38.974985", latitude = "45.046826") to HotelProfile.Address(
        country = "Россия",
        city = "Краснодар",
        addressLine1 = "ул. Московская, 1"
    )
)

val countries = hotelAddresses.map { it.second.country }.toSet().toList()

private fun randomHotelInformation(): HotelProfile.HotelInformation {
    val numberOfBedrooms = Random.nextInt(from = 1, until = 5)
    val numberOfBathrooms = Random.nextInt(from = 1, until = numberOfBedrooms + 1)
    val squareMeters = Random.nextInt(from = 100, until = 350)
    return HotelProfile.HotelInformation(
        numberOfBedrooms = numberOfBedrooms,
        numberOfBathrooms = numberOfBathrooms,
        squareMeters = squareMeters
    )
}

private val photoUrls = listOf(
    "https://images.unsplash.com/photo-1455587734955-081b22074882?ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D&auto=format&fit=crop&w=1170&q=80",
    "https://images.unsplash.com/photo-1542314831-068cd1dbfeeb?ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D&auto=format&fit=crop&w=1170&q=80",
    "https://images.unsplash.com/photo-1496417263034-38ec4f0b665a?ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D&auto=format&fit=crop&w=1171&q=80",
    "https://images.unsplash.com/photo-1679678691263-cc7f30ce02f8?ixlib=rb-4.0.3&ixid=M3wxMjA3fDF8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D&auto=format&fit=crop&w=388&q=80",
    "https://images.unsplash.com/photo-1618773928121-c32242e63f39?ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D&auto=format&fit=crop&w=1170&q=80",
    "https://images.unsplash.com/photo-1564501049412-61c2a3083791?ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D&auto=format&fit=crop&w=1332&q=80",
    "https://images.unsplash.com/photo-1522798514-97ceb8c4f1c8?ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D&auto=format&fit=crop&w=435&q=80",
    "https://images.unsplash.com/photo-1445019980597-93fa8acb246c?ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D&auto=format&fit=crop&w=1174&q=80",
    "https://images.unsplash.com/photo-1611892440504-42a792e24d32?ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D&auto=format&fit=crop&w=1170&q=80",
    "https://images.unsplash.com/photo-1568084680786-a84f91d1153c?ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D&auto=format&fit=crop&w=774&q=80",
    "https://plus.unsplash.com/premium_photo-1678286769762-b6291545d818?ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D&auto=format&fit=crop&w=1170&q=80",
    "https://images.unsplash.com/photo-1518733057094-95b53143d2a7?ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D&auto=format&fit=crop&w=365&q=80",
    "https://images.unsplash.com/photo-1596701062351-8c2c14d1fdd0?ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D&auto=format&fit=crop&w=387&q=80",
    "https://images.unsplash.com/photo-1512918728675-ed5a9ecdebfd?ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D&auto=format&fit=crop&w=1170&q=80",
    "https://images.unsplash.com/photo-1578683010236-d716f9a3f461?ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D&auto=format&fit=crop&w=1170&q=80",
    "https://plus.unsplash.com/premium_photo-1678297269980-16f4be3a15a6?ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D&auto=format&fit=crop&w=1170&q=80",
    "https://images.unsplash.com/photo-1521783988139-89397d761dce?ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D&auto=format&fit=crop&w=725&q=80",
    "https://images.unsplash.com/photo-1596394516093-501ba68a0ba6?ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D&auto=format&fit=crop&w=1170&q=80",
    "https://images.unsplash.com/photo-1554647286-f365d7defc2d?ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D&auto=format&fit=crop&w=387&q=80",
    "https://images.unsplash.com/photo-1551632436-cbf8dd35adfa?ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D&auto=format&fit=crop&w=1171&q=80",
    "https://images.unsplash.com/photo-1596436889106-be35e843f974?ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D&auto=format&fit=crop&w=1170&q=80",
    "https://images.unsplash.com/photo-1561384932-145921ce5214?ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D&auto=format&fit=crop&w=435&q=80",
    "https://images.unsplash.com/photo-1554435517-12c44b0be193?ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D&auto=format&fit=crop&w=435&q=80",
    "https://images.unsplash.com/photo-1600617547577-a486ad1c123d?ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D&auto=format&fit=crop&w=2067&q=80",
    "https://images.unsplash.com/photo-1585436626103-d0035f8cf261?ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D&auto=format&fit=crop&w=387&q=80",
    "https://plus.unsplash.com/premium_photo-1664299647097-7edd0d770ec7?ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D&auto=format&fit=crop&w=1170&q=80",
    "https://images.unsplash.com/photo-1474690455603-a369ec1293f9?ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D&auto=format&fit=crop&w=1170&q=80",
    "https://images.unsplash.com/photo-1455382054916-9c12746cfb43?ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D&auto=format&fit=crop&w=465&q=80",
    "https://plus.unsplash.com/premium_photo-1681922761648-d5e2c3972982?ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D&auto=format&fit=crop&w=1170&q=80",
)

private fun randomPhotoUrls(): List<String> {
    val count = Random.nextInt(from = 5, until = 15)
    val result = mutableSetOf<String>()
    repeat(count) {
        result.add(photoUrls.random())
    }
    return result.toList()
}

private fun randomHotelFacilities(): List<HotelFacility> {
    val hotelFacilities = HotelFacility.values()
    val count = Random.nextInt(from = 4, until = hotelFacilities.size + 1)
    return hotelFacilities.take(count)
}

private fun randomPrice() = Random.nextInt(from = 35, until = 500)

private val hotelDescriptions = listOf(
    "Насладитесь непревзойденной роскошью и комфортом. Этот отель, расположенный в самом сердце города, предлагает захватывающий вид на городской пейзаж и безупречный сервис.",
    "Наслаждайтесь мирным отдыхом. Этот отель, расположенный на берегу,, предлагает спокойную атмосферу и легкий доступ к достопримечательностям города.",
    "Ощутите современную изысканность. Этот отель, расположенный в оживленном центре города, предлагает шикарные номера и легкий доступ к магазинам и развлечениям.",
    "Сбегите в прибрежную гавань, где ритм волн успокаивает вашу душу. Из роскошных номеров и люксов открывается потрясающий вид на океан, а шум чаек создает спокойную атмосферу. Исследуйте нетронутые пляжи, насладитесь свежими морепродуктами и позвольте морскому бризу унести ваши заботы.",
    "Погрузитесь в сердцебиение города, не выходя из нашего современного городского оазиса. Стильные номера станут убежищем среди городской суеты, а панорамные городские пейзажи осветят ваши ночи. Насладитесь разнообразными кулинарными предложениями, откройте для себя культурные достопримечательности и ощутите яркую энергию городской жизни.",
    "Отдохните в горном домике, где вас окружает величие природы. Уютные домики и шале предлагают тепло и комфорт, а высокие вершины создают захватывающий вид. Исследуйте пешеходные тропы, дышите свежим горным воздухом и найдите утешение в объятиях природы.",
    "Вернитесь во времени в нашем историческом заведении, где оживают истории прошлого. Элегантные номера обставлены старинной мебелью, а архитектура отражает ушедшую эпоху. Прогуляйтесь по очаровательным мощеным улочкам, откройте для себя местные традиции и насладитесь вечной красотой истории.",
    "Найдите покой в спокойных объятиях сельской местности. Деревенские домики и коттеджи обеспечивают уютное уединение в окружении холмистых полей и живописных пейзажей. Погрузитесь в активный отдых на свежем воздухе, насладитесь блюдами, приготовленными с фермы, и позвольте неторопливому темпу восстановить ваш дух.",
    "Ощутите современный комфорт в самом сердце современного удобства. Шикарные номера отличаются элегантным дизайном и самыми современными удобствами, а близлежащие достопримечательности предлагают бесконечные развлечения. Расслабьтесь у бассейна, насладитесь изысканной кухней и насладитесь легкостью городского побега.",
    "Откройте для себя очаровательную гавань, расположенную среди пышных садов. Из необычных номеров и люксов открывается вид на сад, где яркие цветы и тихие тропинки манят к исследованию. Погрузитесь в красоту природы, насладитесь ужином на свежем воздухе и позвольте гармонии садов восстановить ваше равновесие.",
    "Ищите приключения в сердце дикой природы, где суровое очарование сочетается с дикой красотой. Хижины и домики создают уютную атмосферу в окружении высоких деревьев и непроходимых троп. Отправляйтесь в экспедиции на открытом воздухе, собирайтесь у костров и вновь окунитесь в первобытное очарование дикой природы.",
    "Найдите уединение в вечном убежище, где царит спокойствие. Уютные коттеджи и апартаменты предлагают уединение и комфорт, создавая идеальный отдых от суеты повседневной жизни. Погрузитесь в медитативные практики, начните комплексное оздоровление и заново откройте для себя свою внутреннюю гармонию.",
    "Погрузитесь в местную культуру в самом сердце нашего оживленного заведения. Номера отражают традиции региона, а близлежащие рынки, галереи и представления позволяют заглянуть в душу сообщества. Пообщайтесь с местными ремесленниками, насладитесь настоящей кухней и позвольте культурному гобелену развернуться вокруг вас."
)

fun randomHotels(count: Int): List<HotelProfile> {
    val result = mutableListOf<HotelProfile>()
    repeat(count) {
        val address = hotelAddresses.random()
        result.add(
            HotelProfile(
                id = UUID.randomUUID().toString(),
                name = hotelNames.random(),
                address = address.second,
                description = hotelDescriptions.random(),
                category = HotelCategory.values().random(),
                facilities = randomHotelFacilities(),
                price = randomPrice().toDouble(),
                imageUrls = randomPhotoUrls(),
                hotelInformation = randomHotelInformation(),
                location = address.first,
                reviews = randomReviews()
            )
        )
    }
    return result
}