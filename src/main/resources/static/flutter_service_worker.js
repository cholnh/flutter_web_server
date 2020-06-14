'use strict';
const CACHE_NAME = 'flutter-app-cache';
const RESOURCES = {
  "assets/AssetManifest.json": "0b41dee802a96917b4f84354e1d997d4",
"assets/assets/facebook_v2.png": "2725f66c56bb9ce5ea0978b97366efb3",
"assets/assets/instagram_v2.png": "525471bbd3651f9faca3a65c9b9a5514",
"assets/assets/kakao_v2.png": "b64dc70bbc221081d18228c927e09e9d",
"assets/assets/loading.gif": "17f1a37d614032adce4603feb20559c6",
"assets/assets/loading_1.gif": "5fd3a5c54e065c6aae609ad99e0f15ce",
"assets/assets/logo.gif": "ab785396d8a5369fd089e8afb9aedf52",
"assets/assets/logo.png": "2bba914a89a1305cb11adef1bdfaadae",
"assets/assets/logo2.gif": "a1f7f0afb666115231c922e1f7d319d8",
"assets/assets/logo3.gif": "dc5a024a5040eb00dd0efbc0ab918f97",
"assets/assets/logo_transparant.png": "36d8c759776bdd83251456278aa4b4c0",
"assets/FontManifest.json": "3babefb4bbd46bff633bb5f15768249a",
"assets/fonts/MaterialIcons-Regular.ttf": "56d3ffdef7a25659eab6a68a3fbfaf16",
"assets/LICENSE": "fd16452448ad49409b7e2d190c28e251",
"assets/packages/cupertino_icons/assets/CupertinoIcons.ttf": "115e937bb829a890521f72d2e664b632",
"assets/packages/flutter_google_maps/assets/images/marker_a.png": "9b687e681fcc41298dfab9c1304b66d0",
"assets/packages/flutter_google_maps/assets/images/marker_b.png": "bb8df73622307b582f89602743f4f02f",
"favicon.png": "5dcef449791fa27946b3d35ad8803796",
"icons/Icon-192.png": "ac9a721a12bbc803b44f645561ecb1e1",
"icons/Icon-512.png": "96e752610906ba2a93c65f8abe1645f1",
"index.html": "f9198a1b3447dc604ef42842e70728bc",
"/": "f9198a1b3447dc604ef42842e70728bc",
"main.dart.js": "958521a5ca5d666805945be51e5f4d1e",
"manifest.json": "4268912422d3df88dad0f682e74344e2"
};

self.addEventListener('activate', function (event) {
  event.waitUntil(
    caches.keys().then(function (cacheName) {
      return caches.delete(cacheName);
    }).then(function (_) {
      return caches.open(CACHE_NAME);
    }).then(function (cache) {
      return cache.addAll(Object.keys(RESOURCES));
    })
  );
});

self.addEventListener('fetch', function (event) {
  event.respondWith(
    caches.match(event.request)
      .then(function (response) {
        if (response) {
          return response;
        }
        return fetch(event.request);
      })
  );
});
