# Conception
<h2>N-tiers architecture</h2>
<h3>Repository package</h3>
Data persistence layer. Provides interfaces for all models. Provides persistence technology-specific abstractions with JpaRepository.
We define some methodes here for access, save, delete or create data.</p>
<h3>Model package</h3>
Domain layer. Provides objects that represent the reality. We define Entities like User, Home, Smardevice with all the information we need.
<h3>Resource package</h3>
Rest API Contoller, we define paths corresponding with some methods that will call services.
<h3>Service package</h3>
Link between controller and repository. It abstracts business logic and data access.
<h2>Data model</h2>
User has friends (other users). User has homes and eclectronic devices. Homes have heaters. Electronic devices and heaters are smart devices (come common attributes).<br>
How to calculate annual electricity consumption ? Smart devices have a number of operating hours per day, a number of operating days per year a wattage. So we can calculate annual consumption per user, home or friend list.<br>
If an user is deleted, his homes and smart devices will be deleted.
