/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 * Author:  robert.jasny
 * Created: 31.07.2017
 */
INSERT INTO zoo (zoo_name) VALUES
  ('Tierpark Hellabrunn'),
  ('Tierpark Berlin'),
  ('Tiergarten Nürnberg');

INSERT INTO gehege (gehege_name, zoo_id) VALUES
  ('Löwenparadies', '1'),
  ('Savanne', '1'),
  ('Eisbärenlandschaft', '1'),
  ('Flusspferdpfuhl', '1');

INSERT INTO tierpfleger (nachname, vorname) VALUES
  ('Kümmerer', 'Hans');

INSERT INTO tier (art, familie, geschlecht, rote_liste, gehege_id, pfleger_id) VALUES
  ('Gepard', 'Katzen', 'weiblich', 'true', '2', '1'),
  ('Gepard', 'Katzen', 'männlich', 'true', '2', '1');

