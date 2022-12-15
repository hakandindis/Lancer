package hakandindis.lancer.util

import hakandindis.lancer.data.local.entity.HeroEntity
import hakandindis.lancer.data.model.Hero

fun heroToEntity(hero: Hero): HeroEntity {
    return HeroEntity(
        id = hero.heroId,
        name = hero.localizedName,
        img = hero.img,
        primaryAttr = hero.primaryAttr
    )
}