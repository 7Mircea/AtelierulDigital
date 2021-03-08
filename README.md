# Networking
An app with three screens that will display:
- Top-rated movies
- Upcoming movies
- Now playing movies

## Implementation
The app consists of three activityes for displaying lists of movies and a main activity for choosing a list to view. It uses Retrofit, a library based on GSON and OkHttp. The later two
are for converting files from json format to POJO(plain old java object), and for http comunication with REST API. The result is shown in a RecyclerView, with a customized adapter.