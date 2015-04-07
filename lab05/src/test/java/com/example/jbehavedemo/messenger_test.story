Given a messenger
When set server name to wp.pl
Then test connection should return 0

When set server name to wp.pl.com
Then test connection should return 1

When set server name to wp
When set message text to tekst
Then send message return 2

When set server name to wp.pl.com
When set message text to tekst
Then send message return 1

When set server name to wp.pl
When set message text to tekst
Then test connection should return 0
Then send message return 0

When set server name to wp.pl.com
When set message text to tekst
Then test connection should return 1
Then send message return 1

When set server name to wp.pl
When set message text to tekst
Then send message return 0

When set server name to wp.pl
When set message text to t
Then send message return 2