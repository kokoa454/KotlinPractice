package com.example.superheroes

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.superheroes.model.Hero
import com.example.superheroes.model.HeroesRepository.heroes
import com.example.superheroes.ui.theme.SuperHeroesTheme

@Composable
fun HeroesCard(hero: Hero, modifier: Modifier = Modifier) {
    Card(
        modifier = modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(16.dp))
    ) {
        Row {
            Column(
                modifier = Modifier
                    .weight(7.5f)
                    .padding(16.dp),
            ) {
                Text(
                    text = stringResource(hero.nameRes),
                    style = MaterialTheme.typography.displaySmall
                )
                Text(
                    text = stringResource(hero.descriptionRes),
                    style = MaterialTheme.typography.bodyLarge
                )
            }
            Image(
                painter = painterResource(hero.imageRes),
                contentDescription = stringResource(hero.nameRes),
                modifier = Modifier
                    .weight(2.5f)
                    .padding(
                        top = 16.dp,
                        bottom = 16.dp,
                        end = 16.dp
                    )
                    .clip(RoundedCornerShape(8.dp))
            )
        }
    }
}

@Composable
fun HeroesList(heroesList: List<Hero>, modifier: Modifier = Modifier) {
    LazyColumn(
        modifier = modifier
    ) {
        items(heroesList) { hero ->
            HeroesCard(
                hero = hero,
                modifier = Modifier.padding(top = 4.dp, bottom = 4.dp)
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun HeroesCardPreview() {
    SuperHeroesTheme {
        HeroesList(heroesList = heroes, modifier = Modifier.padding(start = 16.dp, end = 16.dp))
    }
}