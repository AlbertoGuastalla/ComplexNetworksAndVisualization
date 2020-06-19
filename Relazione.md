# <p align="center">Complex Network Analysis</p>

<h2>Introduzione</h2>

In questa relazione interpreto i risultati ottenuti con tre librerie di Java (JGraphT, Jung e GraphStream) e Gephi riguardanti l’analisi della rete
Twitch Social Network (EN).
La rete presa in esame è un grafo non orientato che è stato creato in seguito all'analisi delle amicizie fra gli streamers inglesi della piattaforma Twitch.
Ogni nodo rappresenta uno streamer e ogni arco l'amicizia fra due streamers.
La rete non è pesata (peso su ogni arco è uguale ad 1 di default).

<h3>Visualizzazione</h3>

<p align="center">
  <img width="500px" height="500px" src="https://github.com/AlbertoGuastalla/ComplexNetworksAndVisualization/blob/master/network.png"/>
</p>

<h3>Considerazioni</h3>

La rete è stata rappresentata con il tool Gephi usando il layout Yifan Hu.
La rete così visualizzata sembra avere gruppo compatto di streamers al centro con tanti outlier posizionati sulla "cresta" del grafo.

<h2>Misure</h2>

<ol>
<h3><li>Generiche</li></h3>
- E' un grafo non orientato<br>
- NON è un multigrafo<br>
- NON sono presenti selfloops<br>
- NON sono presenti nodi isolati<br>
- Numero di Nodi: 7126<br>
- Numero di Archi: 35324<br>
- Numero di archi possibili: 50772750<br>
- Densità: 0.0007 (archi presenti / archi possibili)<br>

<h4>Considerazioni</h4>
La densità è bassissima.
Da una prima e rapida analisi infatti, si nota la presenza di molti nodi con un grado basso e pochi nodi con un grado alto (hubs).
Questa caratteristica è molto ricorrente nelle free-scale network in cui vi è una distribuzione esponenziale negativa del grado dei nodi (es. preferential attachment model).

<h3><li>Distanza</li></h3>
Distanza minima fra ogni coppia di vertici del grafo.

<p align="left">
  <img width="600px" height="300px" src="https://github.com/AlbertoGuastalla/ComplexNetworksAndVisualization/blob/master/distance_distribution.png"/>
</p>
- Media Distanza: 3.677<br>
- Varianza Distanza: 0.735<br>

<h4>Considerazioni</h4>
Si nota subito la presenza del fenomeno del mondo piccolo dato che la media delle distanze è molto bassa.

<h3><li>Grado</li></h3>
Numero di archi uscenti/entranti in un vertice del grafo (grafo non orientato).

<p align="left">
  <img width="600px" height="300px" src="https://github.com/AlbertoGuastalla/ComplexNetworksAndVisualization/blob/master/degree_distribution.png"/>
</p>
- Media Grado: 9.914<br>
- Varianza Grado: 492.40<br>

<h4>Considerazioni</h4>
Come sovracitato, il grafo segue una legge di potenza (almeno asintoticamente).
Cio’ vuol dire che la rete e’ nel regime libero da scala ed e’ presente il fenomeno rich get richer.
Cio’ indica la presenza di hubs che potrebbero essere formati dagli streamers piu’ popolari della piattaforma Twitch.<br>

<h3><li>Centralità</li></h3>
Le misure di centralità permettono di identificare i nodi più importanti all’interno della rete.<br>
Ho considerato diverse misure di centralità:<br>

<h4>Degree Centrality</h4>
Numero di archi incidenti su un nodo.

<p align="left">
  <img width="600px" height="300px"  src="https://github.com/AlbertoGuastalla/ComplexNetworksAndVisualization/blob/master/degree_centrality.png"/>
</p>

<h4>Closeness Centrality</h4>
Reciproco della somma della lunghezza dei percorsi più brevi tra il nodo e tutti gli altri nodi nel grafico. Pertanto, più un nodo è centrale, più è vicino a tutti gli altri nodi.

<p align="left">
  <img width="600px" height="300px"  src="https://github.com/AlbertoGuastalla/ComplexNetworksAndVisualization/blob/master/closeness_centrality.png"/>
</p>

<h4>Harmonic Closeness Centrality</h4>
Somma dei reciproci delle lunghezze dei percorsi più brevi tra il nodo e tutti gli altri nodi nel grafico. Pertanto, più un nodo è centrale, più è vicino a tutti gli altri nodi.

<p align="left">
  <img width="600px" height="300px"  src="https://github.com/AlbertoGuastalla/ComplexNetworksAndVisualization/blob/master/harmonic_closeness_centrality.png"/>
</p>

<h4>Eigenvector Centrality</h4>
Misura di centralità che si basa sulla centralità dei nodi vicini. Un vertice possiede uno score tanto alto quanto è alto lo score dei suoi vicini.

<p align="left">
  <img width="600px" height="300px"  src="https://github.com/AlbertoGuastalla/ComplexNetworksAndVisualization/blob/master/eigenvector_centrality.png"/>
</p>

<h4>Betweenness Centrality</h4>
Misura di centralità che si basa sui cammini minimi attraversanti un determinato vertice. Più cammini minimi attaversano un vertice del grafo, più è alto lo score di tale vertice.

<p align="left">
  <img width="600px" height="300px"  src="https://github.com/AlbertoGuastalla/ComplexNetworksAndVisualization/blob/master/betweeness_centrality.png"/>
</p>

<h4>PageRank</h4>
Misura di centralità che si basa sulla probabilità stazionaria di essere in un determinato vertice del grafo effettuando una camminata randomica sull'ultimo. (Coincide con l'eigenvector centrality qualora il parametro "dumping-factor" venisse settato a 0.0).

<p align="left">
  <img width="600px" height="300px"  src="https://github.com/AlbertoGuastalla/ComplexNetworksAndVisualization/blob/master/page_rank_centrality.png"/>
</p>

<h4>HITS Score</h4>
Misura di centralità che si basa su due punteggi. Un punteggio di hub che misura quanti collegamenti possiede un vertice verso altri vertici chiamati authorities e un punteggio di authority che misura da quanti archi è raggiunto tale nodo dai nodi hubs.
(Se non specificato diversamente, ogni nodo è sia hub che authority, inoltre in un grafo non orientato il numero di archi entranti è uguale al numero di archi uscenti, quindi i due valori coincidono).

<p align="left">
  <img width="600px" height="300px"  src="https://github.com/AlbertoGuastalla/ComplexNetworksAndVisualization/blob/master/hits_authorities_centrality.png"/>
</p>

Per qunto riguarda il calcolo del PageRank e dell'algoritmo HITS, è stato utilizzato un dumping factor pari a 0.20.
Invece per quanto riguarda PageRank, Eigenvetor Centrality e HITS, essendo per natura degli algoritmi che effettuano delle approssimazioni successive, è stato settato un limite di 1000 iterazioni massime.

<h4>Considerazioni</h4>
I grafici mostrano lo score dei primi 50 vertici del grafo in ordine dcrescente di score.
Come è possibile osservare, vi sono sempre i nodi 1773 e 4949 in testa ad ogni grafico, il che porta a pensare che essi rappresentino i nodi maggiormente "influenti" della rete.
In tutti i grafi (ad eccezione dei due tipi di closeness centrality), si può notare un andamento esponenziale (tipico delle reti libere da scala, come già accennato prima).
Nei due grafici rimanenti invece, questo comportamento "esponenziale" non è così evidente come nei casi precedenti a causa della conformazione del grafo; in altre parole, essendo la distanza media molto bassa, i vertici del grafo tendono ad essere molto vicini l'uno dall'altro e quindi gli scores di queste centrality (in particolare dei primi 50 nodi della rete) risultano essere molto simili.<br>

<h3>Clustering Coefficient</h3>
Misura del grado in cui i nodi in un grafico tendono a raggrupparsi insieme.<br>

Global Transitivity: 0.042
Local Transitivity: 0.130

<h4>Considerazioni</h4>
Anche se basso, il coefficiente di clustering risulta almeno 60 volte più grande della densità dell'intero grafo.
Quindi ricapitolando, il grafo è caratterizzato da un bassissimo average path length e da un elevato clustering coefficient (rapportato alla densità del grafo), il che porta a concludere (in accordo con la teoria) che il grafo abbia la proprietà di "Small World".<br>

<h3>Assortatività (omofilia)</h3>
Permette di misurare il grado di correlazione tra i valori degli attributi dei nodi.
Una rete è assortativa se i nodi tendono a connettersi a nodi con valori simili (rispetto a un attributo).
In pratica permette di analizzare l'omofilia (se è assortativo rispetto a un valore c'è omofilia).
Correlazione tra il grado di un nodo e il grado medio dei suoi vicini
Non avendo attributi sui nodi, è stato usato il grado: verifichiamo se i nodi con tanti archi
tendono a collegarsi ad altri nodi con tanti archi.
La pendenza della retta indica se c’è assortatività o meno:<br>
- positiva: assortativo<br>
- negativa: disassortativo<br><br>

<p align="left">
  <img width="600px" height="300px" src="https://github.com/AlbertoGuastalla/ComplexNetworksAndVisualization/blob/master/degree_correlation.png"/>
</p>

Coefficiente di assortatività del grado: -0.336005892

<h4>Considerazioni</h4>

Il grafico mostra una marcata pendenza, in particolare si capisce subito che l’assortatività della rete è
negativa. Ciò è anche confermato dal coefficiente angolare della retta che è negativo.
Possiamo quindi concludere che è presente un segnale di omofilia inversa o disassortatività rispetto al grado dei nodi.
Questo risultato è possibile verificarlo, osservando direttamente il grafo in cui si nota subito che, spostandosi dal centro alla periferia, il grado dei nodi va man mano diminuendo.</ol>

<h2>Struttura</h2>

<ol>
<h3><li>Componenti</li></h3>
Essendo un grafo non orientato, esso è fortemente connesso.
Esso ha una sola componente.

<h3><li>Eccentricità</li></h3>
È la massima distanza tra un nodo e tutti gli altri nodi della rete.<br>
Permette di misurare quanto ogni nodo si trova lontano dal centro della rete.<br>
La distanza tra due nodi è la lunghezza del cammino più breve che li collega.<br><br>
- Diametro della rete: 10 (eccentricità più grande)<br>
- Raggio della rete: 6 (eccentricità più piccola)<br>
- Numero di nodi facenti parte del sottografo indotto dai vertici la cui eccentricità è massima: 5<br>
- Numero di nodi facenti parte del sottografo indotto dai vertici la cui eccentricità è minima: 1115

<h4>Considerazioni</h4>
Dato che il grafo non è orientato, è stato possibile calcolare l’eccentricità di tutti i suoi nodi.
Il numero di nodi che possiedono il valore di eccentricità pari al raggio del grafo sono molti; questo è una conferma sul fatto che gran parte dei nodi del grafo siano posizionati al centro del grafo stesso.

<h3><li>Core e periferia</li></h3>
Una rete sociale è formata da 2 tipi di nodi:<br><br>
- Core (i nodi che sono più o meno strettamente interconnessi)<br>
- Periferia (i nodi che sono strettamente collegati al core, ma solo debolmente tra loro)<br><br>

Nodi del core: 1153 (k-core con k=10)<br>
- Archi del core: 12782<br>
- Nodi della periferia: 5973

<h4>Considerazioni</h4>
Il core è localizzato nel cuore della rete, mentre la periferia è composta dei nodi che fluttuano all'esterno del core.

<h3><li>Community</h3><li>
Ricerca del miglior partizionamento (communities) basato sulla misura della modularità.
La modularità m è la differenza tra:<br><br>
- la frazione degli archi che ricadono all'interno delle comunità date e<br>
- la frazione attesa se gli archi fossero distribuiti in modo casuale (conservando i gradi dei nodi)<br>
- Se la maggior parte degli archi è incidente ai nodi all'interno della stessa comunità, la
modularità sarà positivca e la partizione proposta descrive una
struttura della comunità molto buona.<br>
- Modularità negativa significa che i nodi all'interno della stessa comunità non sono
affatto adiacenti, la struttura della comunità proposta è peggiore di quella casuale.

<h4>Algoritmo di Gephi (Blondel Guillaume Lefebvre based on modularity score)</h4>
<h5>Parametri</h5>
- Risoluzione: 1.0<br>
- Randomizzazione: Si
<h5>Risultati</h5>
- Modularità: 0.451<br>
- Numero comunità rilevate: 16

<p align="center">
  <img src="https://github.com/AlbertoGuastalla/ComplexNetworksAndVisualization/blob/master/communities.png"/>
</p>

<h5>Parametri</h5>
- Risoluzione: 2.0<br>
- Randomizzazione: Si
<h5>Risultati</h5>
- Modularità: 0.37<br>
- Numero comunità rilevate: 3

<h4>Considerazioni</h4>
Con una più bassa risuluzione l'algoritmo trova meno communities ma più coese (anche se la modularità è leggermente più bassa).

<p align="center">
  <img src="https://github.com/AlbertoGuastalla/ComplexNetworksAndVisualization/blob/master/communities1.png"/>
</p></ol>

Modelli causali

Barabasi-Albert model
● Parametri:
- numero nodi: 7126
- numero di archi: 39675

● Analisi
○ grafo non orientato
○ Densità: 0.002
○ Distanza media: 3.481
○ Varianza della distanza: 0.447
○ Grado medio: 11.135
○ Varianza del grado: 260.08
○ Clustering Coefficient: 0.014
○ Assortatività (grado):
Coefficiente: -0.03646606436
○ Componenti:
Il grafo è connesso
Il numero di componenti connesse è 1
○ Algoritmo di Gephi (Blondel Guillaume Lefebvre based on modularity score):
Il numero di comunità rilevate è: 20
● Considerazioni:
È un po più denso del grafo preso in esame.
Il grafo è ancora più compatto (in termini di centralità dei nodi) del grafo preso in esame.
E' parzialmente presente il fenomeno del mondo piccolo dato che la distanza media è 3.481, ma il coefficiente di clustering non è così elevato rapportato alla densità del grafo.
La distribuzione del grado segue una power law proprio come il grafo analizzato nella prima parte, infatti il grado presenta un'elevata variabilità.
Il grafo sembra essere neutrale/disassortativo, infatti il suo coefficiente è
negativo ma è piuttosto vicino a 0.
Non essendo diretto ed essendo connesso, ovviamente c’è una sola componente gigante che
contiene tutti i nodi.

Erdos-Renyi model (gnp model)
● Parametri
Numero nodi: 7126
Numero archi: 35634
● Analisi
○ grafo non orientato
○ Densità: 0.001
○ Distanza media: 4.107
○ Varianza della distanza: 0.452
○ Grado medio: 10.001
○ Varianza del grado: 9.868
○ Clustering Coefficient: 0.001
○ Assortatività (grado):
Coefficiente: -0.009384953056
○ Componenti:
Il grafo è connesso
Il numero di componenti connesse è 1
○ Comunità (Algoritmo Louvain):
Il numero di comunità rilevate è: 21
● Considerazioni:
È un po più denso del grafo preso in esame.
Il grafo è ancora più compatto (in termini di centralità dei nodi) di quello generato dal modello di Barabasi-Albert.
E' parzialmente presente il fenomeno del mondo piccolo dato che la distanza media è 4.107, ma il coefficiente di clustering risulta essere uguale alla densità del grafico.
La distribuzione del grado non segue una power law, quindi assumiamo che non sia
presente il fenomeno rich get richer, questo inoltre è confermato dalla non eccessiva variabilità del grado dei nodi.
Il grafo sembra essere neutrale/disassortativo, infatti il suo coefficiente è
negativo ma è vicinissimo a 0.
Non essendo diretto ed essendo connesso, ovviamente c’è una sola componente gigante che
contiene tutti i nodi.

Watts-Strogatz model
● Parametri
Numero nodi: 7126
Numero archi: 35630
● Analisi
○ grafo non orientato
○ Densità: 0.001
○ Distanza media: 4.323
○ Varianza della distanza: 0.484
○ Grado medio: 9.999
○ Varianza del grado: 3.721
○ Clustering Coefficient: 0.088
○ Assortatività (grado):
Coefficiente: -0.04873289853
○ Componenti:
Il grafo è connesso
○ Comunità (Algoritmo Louvain):
Il numero di comunità rilevate è: 55
● Considerazioni:
È un po più denso del grafo preso in esame.
Il grafo è ancora più compatto (in termini di centralità dei nodi) di quello generato dal modello di Barabasi-Albert.
E' presente il fenomeno del mondo piccolo dato che la distanza media è 4.323, ed il coefficiente di clustering risulta essere addirittura 88 volte più grande della densità del grafo.
La distribuzione del grado non segue una power law, quindi assumiamo che non sia
presente il fenomeno rich get richer, questo inoltre è confermato dalla non eccessiva variabilità del grado dei nodi.
Il grafo sembra essere neutrale/disassortativo, infatti il suo coefficiente è
negativo ma è vicinissimo a 0.
Non essendo diretto ed essendo connesso, ovviamente c’è una sola componente gigante che
contiene tutti i nodi.

Configuration model (grafo rimescolato avente la stessa distirbuzione del grado dei nodi)
● Parametri
Numero nodi: 7126
Numero archi: 33380
● Analisi
○ grafo non orientato
○ Densità: 0.001
○ Distanza media: 3.888
○ Varianza della distanza: 9.368509682851561
○ Grado medio: 9,369
○ Varianza del grado: 343.3493745365369
○ Clustering Coefficient: 0.016
○ Assortatività (grado):
Coefficiente: -0.3486036637
○ Componenti:
Componenti:
Il grafo è connesso
Il numero di componenti connesse è 12
La componente connessa gigante ha 7115 nodi (ed è una sola)
○ Comunità (Algoritmo Louvain):
Il numero di comunità rilevate è: 28
● Considerazioni:
È un po più denso del grafo preso in esame.
Il grafo è meno compatto (in termini di centralità dei nodi) di quello preso in esame.
E' presente il fenomeno del mondo piccolo dato che la distanza media è 3.888, ed il coefficiente di clustering risulta essere 16 volte più grande della densità del grafo.
La distribuzione del grado segue una power law, quindi assumiamo che sia
presente il fenomeno rich get richer, questo inoltre è confermato dalla grande variabilità del grado dei nodi (proprio come nel grafo d'esame).
Il grafico mostra una marcata pendenza, in particolare si capisce subito che l’assortatività della rete è
negativa, ciò è anche confermato dal coefficiente angolare della retta che è negativo.<br><br>

Per il calcolo dei due momenti, è stato utilizzato l'algoritmo online one pass di Wellford per avere una maggiore stabilità numerica.

## AUTORE

* **Alberto Guastalla** - [AlbertoGuastalla](https://github.com/AlbertoGuastalla)
