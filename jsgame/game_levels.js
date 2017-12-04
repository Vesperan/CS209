var GAME_LEVELS = [
  // ["                                                                ",
  //  "                                                                ",
  //  "                                                                ",
  //  "                                                                ",
  //  "                                                                ",
  //  "                        o                                       ",
  //  "                     p                                          ",
  //  "        x                                                       ",
  //  "        x                                                       ",
  //  "        x      p                                                ",
  //  "        x                                                       ",
  //  "  @     x                                                       ",],
  // ["                                                                ",
  //  "                                                                ",
  //  "                                                                ",
  //  "                                                                ",
  //  "                                                                ",
  //  "                    o      xxxx                                 ",
  //  "             xxx                                                ",
  //  "   p  @    o       x                                            ",
  //  "xxxxxxxxxxxxxxxxxx!!!!xxxxxxx!!!!xxxxxxxxxxxx     x   x   x   x ",
  //  "                                                                ",],
  ["                                                                                ",
   "                                                                                ",
   "                                                        o                       ",
   "                                                                                ",
   "                                                                                ",
   "                                                                   o            ",
   "                                                                  sss           ",
   "                                                   aa      xx    ss!ss          ",
   "                                    o o      xx                  x!!!x          ",
   "                    q                                            xx!xx          ",
   "                    q              sssss                          xvx           ",
   "                    q                                                     wxxx  ",
   "  xx                q                                                     w  x  ",
   "  x         q       q   o                  2                              w  x  ",
   "  x         q  1    q                    xxxxx                            wo x  ",
   "  x         qxxxx   q   o                                                 w  x  ",
   "  x  @      qx  x   q                                            xxxxx    w  x  ",
   "  xxxxxxxxxxxx  xxxxxxxxxxxxxxx   xxxxxxxxxxxxxxxxxxxx     xxxxxxx   xxxxxxxxx  ",
   "                              x   x                  x     x                    ",
   "                              x!!!x                  x!!!!!x                    ",
   "                              x!!!x                  x!!!!!x                    ",
   "                              xxxxx                  xxxxxxx                    ",
   "                                                                                ",
   "                                                                                "],
  ["                                                                                                              v   ",
   "                                                                                                                  ", 
   "                                                                                                                  ",
   "                                       i u y t r e                                                                ", 
   "                                       i u y t r e                                                                ",
   "                                       i u y t r e                 xdddx                                          ", 
   "                                       i u y t r e                 x   x                                     x!x  ",
   "                                       i u y t r e                 xjjjx                                     x!x  ",                                                                                                                  
   "                                       i u y t r e                xx   xx                                    x!x  ",
   "                                    o  i u y t r e                xx 8 xx                           e   t    x!x  ",
   "                                    x!!x u y t r e             oo xxxxxxx                           e   t    x!x  ",
   "                                    x!!x u y t r e             xxux utu xuxx                        e   t    x!x  ",
   "                                    x!!xxxxxxxxxxx            xt   t   t   tx                       e   t    x!x  ",
   "                                     xx!!!!!!!!!!xxx         xu             ux                      e   t    x!x  ",
   "                                       xxxxxxxxxx!!x         x                                    o e o t o 4x!x  ",
   "                                                xx!x   hhh   x     6   o           ddddd            e   t   xx!x  ",
   "                                                 x!x         x                                xxxxxxxxxxxxxxx!!x  ",
   "                                                 xvx         x     x   x                        !!!!!!!!!!!!!!xx  ",
   "                                                             xx  |   |   |  xx            xxxxxxxxxxxxxxxxxxxxx   ",
   "                                                              xx!!!!!!!!!!!xx            v                        ",
   "                                               5               xxxx!!!!!xxxx                                      ",
   "                                e   e          x     x            xxxxxxx        xxx         xxx                  ",
   "                                e   e          x     x                           x x         x x                  ",
   "                                e   e          x     x                             x         x                    ",
   "                                e   e          x     x                             xx        x                    ",
   "                                e   e          xx    x                             x         x                    ",
   "                  3             e   e          x     x      o  o     x   x         x         x                    ",
   "               xxxxxxx        xxxhhhxxx        x     x               x   x         x         x                    ",
   "              xx     xx         x   x          x     x     xxxxxx    x   x   xxxxxxxxx       x                    ",
   "             xx       xx        x o x          x    xx               x   x   x               x                    ",
   "     @       x         x        x   x          x     x               x   x   x               x                    ",
   "    xxx      x         x        x   x          x     x               x   xxxxx   xxxxxx      x                    ",
   "    x x      x         x       xx o xx         x     x               x     o     x x         x                    ",
   "!!!!x x!!!!!!x         x!!!!!!xx     xx!!!!!!!!xx    x!!!!!!!!!!     x     =     x x7        x                    ",
   "!!!!x x!!!!!!x         x!!!!!xx       xxxxxxxxxx     x!!!!!!!xx!     xxxxxxxxxxxxx xx  o o  xx                    ",
   "!!!!x x!!!!!!x         x!!!!!x    o                 xx!!!!!!xx !                    xx     xx                     ",
   "!!!!x x!!!!!!x         x!!!!!x                     xx!!!!!!xx  !                     xxxxxxx                      ",
   "!!!!x x!!!!!!x         x!!!!!xx       xxxxxxxxxxxxxx!!!!!!xx   !                                                  ",
   "!!!!x x!!!!!!x         x!!!!!!xxxxxxxxx!!!!!!!!!!!!!!!!!!xx    !                                                  ",
   "!!!!x x!!!!!!x         x!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!xx     !                                                  "],
  ["                                                                                                              ",
   "                                                                                                              ",
   "                                                                                                              ",
   "                                                                                                              ",
   "                                                                                                              ",
   "                                        o                                                                     ",
   "                                                                                                              ",
   "                                        x                                                                     ",
   "                                        x                                                                     ",
   "                                        x                                                                     ",
   "                                        x                                                                     ",
   "                                       xxx                                                                    ",
   "                                       x x                 !!!        !!!  xxx                                ",
   "                                       x x                 !x!        !x!                                     ",
   "                                     xxx xxx                x          x                                      ",
   "                                      x   x                 x   oooo   x       xxx                            ",
   "                                      x   x                 x          x      x!!!x                           ",
   "                                      x   x                 xxxxxxxxxxxx       xxx                            ",
   "                                     xx   xx      x   x      x                                                ",
   "                                      x   xxxxxxxxx   xxxxxxxx              x x                               ",
   "                                      x   x           x                    x!!!x                              ",
   "                                      x   x           x                     xxx                               ",
   "                                     xx   xx          x                                                       ",
   "                                      x   x= = = =    x            xxx                                        ",
   "                                      x   x           x           x!!!x                                       ",
   "                                      x   x    = = = =x     o      xxx       xxx                              ",
   "                                     xx   xx          x                     x!!!x                             ",
   "                              o   o   x   x           x     x                xxv        xxx                   ",
   "                                      x   x           x              x                 x!!!x                  ",
   "                             xxx xxx xxx xxx     o o  x!!!!!!!!!!!!!!x                   vx                   ",
   "                             x xxx x x xxx x          x!!!!!!!!!!!!!!x                                        ",
   "                             x             x   xxxxxxxxxxxxxxxxxxxxxxx                                        ",
   "                             xx           xx                                         xxx                      ",
   "  xxx               w         x     x     x                                         x!!!x                xxx  ",
   "  x x               w         x    xxx    x                                          xxx                 x x  ",
   "  x                 w         x    xxx    xxxxxxx                        xxxxx                             x  ",
   "  x                 w         x           x                              x   x                             x  ",
   "  x                 w         xx          x                              x x x                             x  ",
   "  x                 w                     x       |xxxx|    |xxxx|     xxx xxx                             x  ",
   "  x                xxx             o o    x                              x         xxx                     x  ",
   "  x               xxxxx       xx          x                             xxx       x!!!x          x         x  ",
   "  x               oxxxo       x    xxx    x                             x x        xxx          xxx        x  ",
   "  x                xxx        xxxxxxxxxxxxx  x oo x    x oo x    x oo  xx xx                    xxx        x  ",
   "  x      @          x         x           x!!x    x!!!!x    x!!!!x    xx   xx                    x         x  ",
   "  xxxxxxxxxxxxxxxxxxxxxxxxxxxxx           xxxxxxxxxxxxxxxxxxxxxxxxxxxxx     xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx  ",
   "                                                                                                              ",
   "                                                                                                              "],
  ["                                                                                                  xxx x       ",
   "                                                                                                      x       ",
   "                                                                                                  xxxxx       ",
   "                                                                                                  x           ",
   "                                                                                                  x xxx       ",
   "                          o                                                                       x x x       ",
   "                                                                                             o o oxxx x       ",
   "                   xxx                                                                                x       ",
   "       !  o  !                                                xxxxx xxxxx xxxxx xxxxx xxxxx xxxxx xxxxx       ",
   "       x     x                                                x   x x   x x   x x   x x   x x   x x           ",
   "       x= o  x            x                                   xxx x xxx x xxx x xxx x xxx x xxx x xxxxx       ",
   "       x     x                                                  x x   x x   x x   x x   x x   x x     x       ",
   "       !  o  !            o                                  xxxx xxxxx xxxxx xxxxx xxxxx xxxxx xxxxxxx       ",
   "                                                                                                              ",
   "          o              xxx                              xx                                                  ",
   "                                                                                                              ",
   "                                                                                                              ",
   "                                                      xx                                                      ",
   "                   xxx         xxx                                                                            ",
   "                                                                                                              ",
   "                          o                                                     x      x                      ",
   "                                                          xx     xx                                           ",
   "             xxx         xxx         xxx                                 x                  x                 ",
   "                                                                                                              ",
   "                                                                 ||                                           ",
   "  xxxxxxxxxxx                                                                                                 ",
   "  x         x o xxxxxxxxx o xxxxxxxxx o xx                                                x                   ",
   "  x         x   x       x   x       x   x                 ||                  x     x                         ",
   "  x  @      xxxxx   o   xxxxx   o   xxxxx                                                                     ",
   "  xxxxxxx                                     xxxxx       xx     xx     xxx                                   ",
   "        x=                  =                =x   x                     xxx                                   ",
   "        xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx   x!!!!!!!!!!!!!!!!!!!!!xxx!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!",
   "                                                  xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx",
   "                                                                                                              "]
];

if (typeof module != "undefined" && module.exports)
  module.exports = GAME_LEVELS;
