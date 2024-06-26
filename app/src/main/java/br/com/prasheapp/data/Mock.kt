package br.com.prasheapp.data

import br.com.prasheapp.infra.MotivationConstants
import kotlin.random.Random


data class Phrase(val description: String, val category: Int, val language: String) {

}

class Mock {

    val all = MotivationConstants.FILTER.ALL
    val sunny = MotivationConstants.FILTER.SUNNY
    val happy = MotivationConstants.FILTER.HAPPY
    private val langEn = MotivationConstants.LANGUAGE.ENGLISH
    private val langPtBR = MotivationConstants.LANGUAGE.PORTUGUESE
    private val langFr = MotivationConstants.LANGUAGE.FRENCH

    val listPhrases: List<Phrase> = listOf(

         Phrase("Não sabendo que era impossível, foi lá e fez.", happy, langPtBR),
         Phrase("Você não é derrotado quando perde, você é derrotado quando desiste!", happy, langPtBR),
         Phrase("Quando está mais escuro, vemos mais estrelas!", happy, langPtBR),
         Phrase("Insanidade é fazer sempre a mesma coisa e esperar um resultado diferente.", happy, langPtBR),
         Phrase("Não pare quando estiver cansado, pare quando tiver terminado.", happy, langPtBR),
         Phrase("O que você pode fazer agora que tem o maior impacto sobre o seu sucesso?", happy, langPtBR),
         Phrase("A melhor maneira de prever o futuro é inventá-lo.", sunny, langPtBR),
         Phrase("Você perde todas as chances que você não aproveita.", sunny, langPtBR),
         Phrase("Fracasso é o condimento que dá sabor ao sucesso.", sunny, langPtBR),
         Phrase(" Enquanto não estivermos comprometidos, haverá hesitação!", sunny, langPtBR),
         Phrase("Se você não sabe onde quer ir, qualquer caminho serve.", sunny, langPtBR),
         Phrase("Se você acredita, faz toda a diferença.", sunny, langPtBR),
         Phrase("Riscos devem ser corridos, porque o maior perigo é não arriscar nada!", sunny, langPtBR),

        Phrase("Not knowing it was impossible, he went there and did it.", happy, langEn),
        Phrase("You are not defeated when you lose, you are defeated when you give up!", happy, langEn),
        Phrase("When it's darker, we see more stars!", happy, langEn),
        Phrase("Insanity is always doing the same thing and expecting a different result.", happy, langEn),
        Phrase("Don't stop when you're tired, stop when you're done.", happy, langEn),
        Phrase("What can you do now that has the biggest impact on your success?", happy, langEn),
        Phrase("The best way to predict the future is to invent it.", sunny, langEn),
        Phrase("You lose every chance you don't take.", sunny, langEn),
        Phrase("Failure is the spice that flavors success.", sunny, langEn),
        Phrase(" As long as we are not committed, there will be hesitation!", sunny, langEn),
        Phrase("If you don't know where you want to go, any way will do.", sunny, langEn),
        Phrase("If you believe, it makes all the difference.", sunny, langEn),
        Phrase("Risks must be taken, because the greatest danger is not risking anything!", sunny, langEn),

        Phrase("Ne sachant pas que c'était impossible, il y est allé et l'a fait.", happy, langFr),
        Phrase("Tu n'es pas vaincu quand tu perds, tu es vaincu quand tu abandonnes!", happy, langFr),
        Phrase("Quand il fait plus sombre, on voit plus d'étoiles!", happy, langFr),
        Phrase("La folie, c'est toujours faire la même chose et s'attendre à un résultat différent.", happy, langFr),
        Phrase("Ne t'arrête pas quand tu es fatigué, arrête quand tu as fini.", happy, langFr),
        Phrase("Que pouvez-vous faire maintenant qui a le plus grand impact sur votre succès?", happy, langFr),
        Phrase("La meilleure façon de prédire l'avenir est de l'inventer.", sunny, langFr),
        Phrase("Vous perdez toutes les chances que vous ne prenez pas.", sunny, langFr),
        Phrase("L'échec est l'épice qui parfume le succès.", sunny, langFr),
        Phrase("Tant qu'on n'est pas engagé, il y aura des hésitations!", sunny, langFr),
        Phrase("Si vous ne savez pas où vous voulez aller, n'importe quoi fera l'affaire.", sunny, langFr),
        Phrase("Si vous croyez, cela fait toute la différence.", sunny, langFr),
        Phrase("Il faut prendre des risques, car le plus grand danger est de ne rien risquer!", sunny, langFr)
    )

    fun getPhrase(value: Int, language: String): String {
        var langFilter = language.lowercase()
        if (language !in listOf(langEn, langPtBR, langFr)) {
            langFilter = langPtBR
        }

        val filtered = listPhrases.filter {
            (it.category == value || value == all) && (it.language == langFilter)
        }

        val rand = Random.nextInt(filtered.size)

        return filtered[rand].description
    }
}