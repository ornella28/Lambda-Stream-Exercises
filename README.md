1. Stram API was easier to understand for tasks like filtering, mapping and sorting. They are more focused on what should happen instead of how it happens
2. map, filter, sotred felt like data transformations because they returned new values without chaning anuthing else. those which felt like side effects were forEach
3. Predicate fits naturally in filter(), Function used for transforming data into something else fits in map(), consumer used for printing fits in forEach()
